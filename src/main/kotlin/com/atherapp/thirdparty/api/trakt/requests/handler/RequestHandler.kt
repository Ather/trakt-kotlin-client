package com.atherapp.thirdparty.api.trakt.requests.handler

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.core.Constants
import com.atherapp.thirdparty.api.trakt.exceptions.*
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktError
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.TraktCheckinPostErrorResponse
import com.atherapp.thirdparty.api.trakt.requests.base.RequestObjectType.*
import com.atherapp.thirdparty.api.trakt.requests.checkins.CheckinRequest
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody
import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.*
import com.atherapp.thirdparty.api.trakt.responses.TraktListResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import com.atherapp.thirdparty.api.trakt.utils.Json
import com.github.kittinunf.fuel.core.Response
import com.google.gson.JsonParseException
import com.google.gson.JsonParser
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.HttpURLConnection
import java.nio.charset.Charset
import kotlin.reflect.KClass

internal class RequestHandler(
        override val client: TraktClient
) : IRequestHandler {

    private val requestMessageBuilder: RequestMessageBuilder = RequestMessageBuilder(client)

    override fun executeNoContentRequestAsync(request: IRequest, requestAuthorization: TraktAuthorization): Deferred<TraktNoContentResponse> {
        preExecuteRequest(request)
        return queryNoContentAsync(requestMessageBuilder.reset(request).withAuthorization(requestAuthorization).build())
    }

    override fun <TRequestBodyType : IRequestBody> executeNoContentRequestAsync(request: IPostRequest<TRequestBodyType>, requestAuthorization: TraktAuthorization): Deferred<TraktNoContentResponse> {
        preExecuteRequest(request)
        return queryNoContentAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build())
    }

    override fun <TRequestBodyType : IRequestBody> executeNoContentRequestAsync(request: IPutRequest<TRequestBodyType>, requestAuthorization: TraktAuthorization): Deferred<TraktNoContentResponse> {
        preExecuteRequest(request)
        return queryNoContentAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build())
    }

    override fun <TResponseContentType : Any> executeSingleItemRequestAsync(request: IRequestHasResponse<TResponseContentType>, requestAuthorization: TraktAuthorization): Deferred<TraktResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return querySingleItemAsync(requestMessageBuilder.reset(request).withAuthorization(requestAuthorization).build(), request.responseContentClass, false)
    }

    override fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executeSingleItemRequestAsync(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization): Deferred<TraktResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return querySingleItemAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build(), request.responseContentClass, request is CheckinRequest<TResponseContentType, TRequestBodyType>)
    }

    override fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executeSingleItemRequestAsync(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization): Deferred<TraktResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return querySingleItemAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build(), request.responseContentClass, false)
    }

    override fun <TResponseContentType : Any> executeListRequestAsync(request: IRequestHasResponse<TResponseContentType>, requestAuthorization: TraktAuthorization): Deferred<TraktListResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return queryListAsync(requestMessageBuilder.reset(request).withAuthorization(requestAuthorization).build(), request.responseContentClass)
    }

    override fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executeListRequestAsync(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization): Deferred<TraktListResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return queryListAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build(), request.responseContentClass)
    }

    override fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executeListRequestAsync(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization): Deferred<TraktListResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return queryListAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build(), request.responseContentClass)
    }

    override fun <TResponseContentType : Any> executePagedRequestAsync(request: IRequestHasResponse<TResponseContentType>, requestAuthorization: TraktAuthorization): Deferred<TraktPagedResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return queryPagedListAsync(requestMessageBuilder.reset(request).withAuthorization(requestAuthorization).build(), request.responseContentClass)
    }

    override fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executePagedRequestAsync(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization): Deferred<TraktPagedResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return queryPagedListAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build(), request.responseContentClass)
    }

    override fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executePagedRequestAsync(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization): Deferred<TraktPagedResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return queryPagedListAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build(), request.responseContentClass)
    }

    private fun queryNoContentAsync(requestMessage: ExtendedHttpRequestMessage): Deferred<TraktNoContentResponse> = GlobalScope.async {
        return@async try {
            executeRequestAsync(requestMessage, false).await().let {
                checkNotNull(it)
                check(it.statusCode == HttpURLConnection.HTTP_NO_CONTENT)
                TraktNoContentResponse().apply { isSuccess = true }
            }
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e

            TraktNoContentResponse().apply {
                isSuccess = false
                exception = e
            }
        }
    }

    private fun <TResponseContentType : Any> querySingleItemAsync(requestMessage: ExtendedHttpRequestMessage, responseContentClass: KClass<TResponseContentType>, isCheckinRequest: Boolean = false): Deferred<TraktResponse<TResponseContentType>> = GlobalScope.async {
        try {
            return@async executeRequestAsync(requestMessage, isCheckinRequest).await().let {
                checkNotNull(it)
                check(it.statusCode != HttpURLConnection.HTTP_NO_CONTENT)
                val contentObject = Json.deserialize<TResponseContentType>(it.data.toString(Charset.forName("UTF-8")), responseContentClass.java)

                val response = TraktResponse<TResponseContentType>(responseContentClass).apply {
                    isSuccess = true
                    hasValue = true
                    value = contentObject
                }

                ResponseHeaderParser.parseResponseHeaderValues(response, it.headers)

                return@let response
            }
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e

            return@async TraktResponse<TResponseContentType>(responseContentClass).apply {
                isSuccess = false
                exception = e
            }
        }
    }

    private fun <TResponseContentType : Any> queryListAsync(requestMessage: ExtendedHttpRequestMessage, responseContentClass: KClass<TResponseContentType>): Deferred<TraktListResponse<TResponseContentType>> = GlobalScope.async {
        try {
            return@async executeRequestAsync(requestMessage, false).await().let {
                checkNotNull(it)
                check(it.statusCode != HttpURLConnection.HTTP_NO_CONTENT)
                val jsonElement = JsonParser().parse(it.data.toString(Charset.forName("UTF-8")))
                val contentObject = jsonElement.asJsonArray.map { obj -> Json.deserialize<TResponseContentType>(obj, responseContentClass.java) }.toMutableList()

                val response = TraktListResponse<TResponseContentType>(responseContentClass).apply {
                    isSuccess = true
                    hasValue = true
                    value = contentObject
                }

                ResponseHeaderParser.parseResponseHeaderValues(response, it.headers)

                return@let response
            }
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e

            return@async TraktListResponse<TResponseContentType>(responseContentClass).apply {
                isSuccess = false
                exception = e
            }
        }
    }

    private fun <TResponseContentType : Any> queryPagedListAsync(requestMessage: ExtendedHttpRequestMessage, responseContentClass: KClass<TResponseContentType>): Deferred<TraktPagedResponse<TResponseContentType>> = GlobalScope.async {
        try {
            return@async executeRequestAsync(requestMessage, false).await().let {
                checkNotNull(it)
                check(it.statusCode != HttpURLConnection.HTTP_NO_CONTENT)
                val jsonElement = JsonParser().parse(it.data.toString(Charset.forName("UTF-8")))
                val contentObject = jsonElement.asJsonArray.map { obj -> Json.deserialize<TResponseContentType>(obj, responseContentClass.java) }.toMutableList()

                val response = TraktPagedResponse<TResponseContentType>(responseContentClass).apply {
                    isSuccess = true
                    hasValue = true
                    value = contentObject
                }

                ResponseHeaderParser.parsePagedResponseHeaderValue(response, it.headers)

                return@let response
            }
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e

            return@async TraktPagedResponse<TResponseContentType>(responseContentClass).apply {
                isSuccess = false
                exception = e
            }
        }
    }

    private fun executeRequestAsync(requestMessage: ExtendedHttpRequestMessage, isCheckinRequest: Boolean = false): Deferred<Response> = GlobalScope.async {
        setDefaultRequestHeaders(requestMessage)

        val response = requestMessage.request.response().second
        if (response.statusCode !in 200..299)
            ResponseErrorHandler.handleErrorsAsync(requestMessage, response, isCheckinRequest)

        return@async response
    }

    private fun preExecuteRequest(request: IRequest) {
        validateRequest(request)
    }

    private fun validateRequest(request: IRequest) {
        request.validate()
    }

    private fun setDefaultRequestHeaders(requestMessage: ExtendedHttpRequestMessage) {
        requestMessage.request.header("Accept" to Constants.MEDIA_TYPE)
        requestMessage.request.header("Content-Type" to Constants.MEDIA_TYPE)
    }
}
