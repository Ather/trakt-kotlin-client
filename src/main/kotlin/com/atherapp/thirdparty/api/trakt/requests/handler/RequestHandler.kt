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

        val (_, response, _) = requestMessage.request.response()
        if (response.statusCode !in 200..299)
            errorHandling(response, requestMessage, isCheckinRequest)

        return@async response
    }

    private fun preExecuteRequest(request: IRequest) {
        validateRequest(request)
    }

    private fun validateRequest(request: IRequest) {
        request.validate()
    }

    private fun setDefaultRequestHeaders(requestMessage: ExtendedHttpRequestMessage) {
        requestMessage.request.header(Constants.API_CLIENT_ID_HEADER_KEY to "${client.clientId}")
        requestMessage.request.header(Constants.API_VERSION_HEADER_KEY to "${client.configuration.apiVersion}")

        requestMessage.request.header("Accept" to Constants.MEDIA_TYPE)
        requestMessage.request.header("Content-Type" to Constants.MEDIA_TYPE)
    }

    private fun errorHandling(httpResponse: Response, requestMessage: ExtendedHttpRequestMessage, isCheckinRequest: Boolean = false) {
        var responseContent = ""

        if (httpResponse.data.isNotEmpty())
            responseContent = httpResponse.data.toString(Charset.forName("UTF-8"))

        val code = httpResponse.statusCode
        val url = requestMessage.request.url.toString()
        val requestBodyJson = requestMessage.requestBodyJson
        val reasonPhrase = httpResponse.responseMessage

        when (code) {
            HttpURLConnection.HTTP_NOT_FOUND -> handleNotFoundStatusCode(requestMessage, responseContent, url, requestBodyJson, reasonPhrase)
            HttpURLConnection.HTTP_BAD_REQUEST -> throw TraktBadRequestException().apply {
                requestUrl = url
                requestBody = requestBodyJson
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_UNAUTHORIZED -> throw TraktAuthorizationException().apply {
                requestUrl = url
                requestBody = requestBodyJson
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_FORBIDDEN -> throw TraktForbiddenException().apply {
                requestUrl = url
                requestBody = requestBodyJson
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_BAD_METHOD -> throw TraktMethodNotFoundException().apply {
                requestUrl = url
                requestBody = requestBodyJson
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_CONFLICT -> handleConflictStatusCode(isCheckinRequest, responseContent, url, requestBodyJson, reasonPhrase)
            HttpURLConnection.HTTP_INTERNAL_ERROR -> throw TraktServerException().apply {
                requestUrl = url
                requestBody = requestBodyJson
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_BAD_GATEWAY -> throw TraktBadGatewayException().apply {
                requestUrl = url
                requestBody = requestBodyJson
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_PRECON_FAILED -> throw TraktPreconditionFailedException().apply {
                requestUrl = url
                requestBody = requestBodyJson
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            422 -> throw TraktValidationException().apply {
                requestUrl = url
                requestBody = requestBodyJson
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            429 -> throw TraktRateLimitException().apply {
                requestUrl = url
                requestBody = requestBodyJson
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            HttpURLConnection.HTTP_UNAVAILABLE, HttpURLConnection.HTTP_GATEWAY_TIMEOUT -> throw TraktServerUnavailableException("Service Unavailable - server overloaded (try again in 30s)").apply {
                requestUrl = url
                requestBody = requestBodyJson
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
            520, 521, 522 -> throw TraktServerUnavailableException("Service Unavailable - Cloudflare error").apply {
                requestUrl = url
                requestBody = requestBodyJson
                response = responseContent
                serverReasonPhrase = reasonPhrase
            }
        }

        handleUnknownError(responseContent, code, url, requestBodyJson, reasonPhrase)
    }

    private fun handleNotFoundStatusCode(requestMessage: ExtendedHttpRequestMessage, responseContent: String, url: String, requestBodyJson: String, reasonPhrase: String) {
        val requestObjectType = requestMessage.requestObjectType

        if (requestObjectType != null) {
            val objectId = requestMessage.objectId
            val seasonNr = requestMessage.seasonNumber ?: 0
            val episodeNr = requestMessage.episodeNumber ?: 0

            when (requestObjectType) {
                Episodes -> throw TraktEpisodeNotFoundException(objectId, seasonNr, episodeNr).apply {
                    requestUrl = url
                    requestBody = requestBodyJson
                    response = responseContent
                    serverReasonPhrase = reasonPhrase
                }
                Movies -> throw TraktMovieNotFoundException(objectId).apply {
                    requestUrl = url
                    requestBody = requestBodyJson
                    response = responseContent
                    serverReasonPhrase = reasonPhrase
                }
                Shows -> throw TraktShowNotFoundException(objectId).apply {
                    requestUrl = url
                    requestBody = requestBodyJson
                    response = responseContent
                    serverReasonPhrase = reasonPhrase
                }
                Seasons -> throw TraktSeasonNotFoundException(objectId, seasonNr).apply {
                    requestUrl = url
                    requestBody = requestBodyJson
                    response = responseContent
                    serverReasonPhrase = reasonPhrase
                }
                People -> throw TraktPersonNotFoundException(objectId).apply {
                    requestUrl = url
                    requestBody = requestBodyJson
                    response = responseContent
                    serverReasonPhrase = reasonPhrase
                }
                Comments -> throw TraktCommentNotFoundException(objectId).apply {
                    requestUrl = url
                    requestBody = requestBodyJson
                    response = responseContent
                    serverReasonPhrase = reasonPhrase
                }
                Lists -> throw TraktListNotFoundException(objectId).apply {
                    requestUrl = url
                    requestBody = requestBodyJson
                    response = responseContent
                    serverReasonPhrase = reasonPhrase
                }
                else -> throw TraktObjectNotFoundException(objectId).apply {
                    requestUrl = url
                    requestBody = requestBodyJson
                    response = responseContent
                    serverReasonPhrase = reasonPhrase
                }
            }
        }

        throw TraktNotFoundException("Resource not found - Reason Phrase: $reasonPhrase")
    }

    private fun handleConflictStatusCode(isCheckinRequest: Boolean, responseContent: String, url: String, requestBodyJson: String, reasonPhrase: String) {
        if (isCheckinRequest) {
            var errorResponse: TraktCheckinPostErrorResponse? = null

            if (!responseContent.isBlank()) {
                try {
                    errorResponse = Json.deserialize(responseContent)
                } catch (e: JsonParseException) {
                    throw TraktException("json convert exception", e)
                }
            }

            throw TraktCheckinException("checkin is already in progress").apply {
                requestUrl = url
                requestBody = requestBodyJson
                response = responseContent
                serverReasonPhrase = reasonPhrase
                expiresAt = errorResponse?.expiresAt
            }
        }

        throw TraktConflictException().apply {
            requestUrl = url
            requestBody = requestBodyJson
            response = responseContent
            serverReasonPhrase = reasonPhrase
        }
    }

    private fun handleUnknownError(responseContent: String, code: Int, url: String, requestBodyJson: String, reasonPhrase: String) {
        val error: TraktError

        try {
            error = Json.deserialize(responseContent)
        } catch (e: JsonParseException) {
            throw TraktException("json convert exception", e)
        }

        val errorMessage =
                if (error.description.isBlank())
                    "Trakt API error without content. Response status code was $code"
                else error.description

        throw TraktException(errorMessage).apply {
            requestUrl = url
            requestBody = requestBodyJson
            response = responseContent
            serverReasonPhrase = reasonPhrase
        }
    }
}
