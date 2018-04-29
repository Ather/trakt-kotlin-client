package com.atherapp.thirdparty.api.trakt.requests.handler

import com.google.gson.JsonParseException
import com.google.gson.JsonParser
import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.core.Constants
import com.atherapp.thirdparty.api.trakt.exceptions.*
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
import org.asynchttpclient.AsyncHttpClient
import org.asynchttpclient.Dsl.asyncHttpClient
import org.asynchttpclient.Response
import java.net.HttpURLConnection
import java.util.concurrent.CompletableFuture
import kotlin.reflect.KClass

internal class RequestHandler(
        override val client: TraktClient
) : IRequestHandler {

    private val requestMessageBuilder: RequestMessageBuilder = RequestMessageBuilder(client)

    override fun executeNoContentRequestAsync(request: IRequest, requestAuthorization: TraktAuthorization): CompletableFuture<TraktNoContentResponse> {
        preExecuteRequest(request)
        return queryNoContentAsync(requestMessageBuilder.reset(request).withAuthorization(requestAuthorization).build())
    }

    override fun <TRequestBodyType : IRequestBody> executeNoContentRequestAsync(request: IPostRequest<TRequestBodyType>, requestAuthorization: TraktAuthorization): CompletableFuture<TraktNoContentResponse> {
        preExecuteRequest(request)
        return queryNoContentAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build())
    }

    override fun <TRequestBodyType : IRequestBody> executeNoContentRequestAsync(request: IPutRequest<TRequestBodyType>, requestAuthorization: TraktAuthorization): CompletableFuture<TraktNoContentResponse> {
        preExecuteRequest(request)
        return queryNoContentAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build())
    }

    override fun <TResponseContentType : Any> executeSingleItemRequestAsync(request: IRequestHasResponse<TResponseContentType>, requestAuthorization: TraktAuthorization): CompletableFuture<TraktResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return querySingleItemAsync(requestMessageBuilder.reset(request).withAuthorization(requestAuthorization).build(), request.responseContentClass, false)
    }

    override fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executeSingleItemRequestAsync(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization): CompletableFuture<TraktResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return querySingleItemAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build(), request.responseContentClass, request is CheckinRequest<TResponseContentType, TRequestBodyType>)
    }

    override fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executeSingleItemRequestAsync(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization): CompletableFuture<TraktResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return querySingleItemAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build(), request.responseContentClass, false)
    }

    override fun <TResponseContentType : Any> executeListRequestAsync(request: IRequestHasResponse<TResponseContentType>, requestAuthorization: TraktAuthorization): CompletableFuture<TraktListResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return queryListAsync(requestMessageBuilder.reset(request).withAuthorization(requestAuthorization).build(), request.responseContentClass)
    }

    override fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executeListRequestAsync(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization): CompletableFuture<TraktListResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return queryListAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build(), request.responseContentClass)
    }

    override fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executeListRequestAsync(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization): CompletableFuture<TraktListResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return queryListAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build(), request.responseContentClass)
    }

    override fun <TResponseContentType : Any> executePagedRequestAsync(request: IRequestHasResponse<TResponseContentType>, requestAuthorization: TraktAuthorization): CompletableFuture<TraktPagedResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return queryPagedListAsync(requestMessageBuilder.reset(request).withAuthorization(requestAuthorization).build(), request.responseContentClass)
    }

    override fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executePagedRequestAsync(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization): CompletableFuture<TraktPagedResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return queryPagedListAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build(), request.responseContentClass)
    }

    override fun <TResponseContentType : Any, TRequestBodyType : IRequestBody> executePagedRequestAsync(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>, requestAuthorization: TraktAuthorization): CompletableFuture<TraktPagedResponse<TResponseContentType>> {
        preExecuteRequest(request)
        return queryPagedListAsync(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).withAuthorization(requestAuthorization).build(), request.responseContentClass)
    }

    private fun queryNoContentAsync(requestMessage: ExtendedHttpRequestMessage): CompletableFuture<TraktNoContentResponse> {
        return try {
            return executeRequestAsync(requestMessage, false).thenApply {
                checkNotNull(it)
                check(it.statusCode == HttpURLConnection.HTTP_NO_CONTENT)
                TraktNoContentResponse().apply { isSuccess = true }
            }
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e

            CompletableFuture.completedFuture(
                    TraktNoContentResponse().apply {
                        isSuccess = false
                        exception = e
                    }
            )
        }
    }

    private fun <TResponseContentType : Any> querySingleItemAsync(requestMessage: ExtendedHttpRequestMessage, responseContentClass: KClass<TResponseContentType>, isCheckinRequest: Boolean = false): CompletableFuture<TraktResponse<TResponseContentType>> {
        try {
            return executeRequestAsync(requestMessage, isCheckinRequest).thenApply {
                checkNotNull(it)
                check(it.statusCode != HttpURLConnection.HTTP_NO_CONTENT)
                val contentObject = Json.deserialize<TResponseContentType>(it.responseBody, responseContentClass.java)

                val response = TraktResponse<TResponseContentType>(responseContentClass).apply {
                    isSuccess = true
                    hasValue = true
                    value = contentObject
                }

                if (it.headers != null)
                    ResponseHeaderParser.parseResponseHeaderValues(response, it.headers)

                return@thenApply response
            }
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e

            return CompletableFuture.completedFuture(
                    TraktResponse<TResponseContentType>(responseContentClass).apply {
                        isSuccess = false
                        exception = e
                    }
            )
        }
    }

    private fun <TResponseContentType : Any> queryListAsync(requestMessage: ExtendedHttpRequestMessage, responseContentClass: KClass<TResponseContentType>): CompletableFuture<TraktListResponse<TResponseContentType>> {
        try {
            return executeRequestAsync(requestMessage, false).thenApply {
                checkNotNull(it)
                check(it.statusCode != HttpURLConnection.HTTP_NO_CONTENT)
                val jsonElement = JsonParser().parse(it.responseBody)
                val contentObject = jsonElement.asJsonArray.map { obj -> Json.deserialize<TResponseContentType>(obj, responseContentClass.java) }.toMutableList()

                val response = TraktListResponse<TResponseContentType>(responseContentClass).apply {
                    isSuccess = true
                    hasValue = true
                    value = contentObject
                }

                if (it.headers != null)
                    ResponseHeaderParser.parseResponseHeaderValues(response, it.headers)

                return@thenApply response
            }
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e

            return CompletableFuture.completedFuture(
                    TraktListResponse<TResponseContentType>(responseContentClass).apply {
                        isSuccess = false
                        exception = e
                    }
            )
        }
    }

    private fun <TResponseContentType : Any> queryPagedListAsync(requestMessage: ExtendedHttpRequestMessage, responseContentClass: KClass<TResponseContentType>): CompletableFuture<TraktPagedResponse<TResponseContentType>> {
        try {
            return executeRequestAsync(requestMessage, false).thenApply {
                checkNotNull(it)
                check(it.statusCode != HttpURLConnection.HTTP_NO_CONTENT)
                val jsonElement = JsonParser().parse(it.responseBody)
                val contentObject = jsonElement.asJsonArray.map { obj -> Json.deserialize<TResponseContentType>(obj, responseContentClass.java) }.toMutableList()

                val response = TraktPagedResponse<TResponseContentType>(responseContentClass).apply {
                    isSuccess = true
                    hasValue = true
                    value = contentObject
                }

                if (it.headers != null)
                    ResponseHeaderParser.parsePagedResponseHeaderValue(response, it.headers)

                return@thenApply response
            }
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e

            return CompletableFuture.completedFuture(
                    TraktPagedResponse<TResponseContentType>(responseContentClass).apply {
                        isSuccess = false
                        exception = e
                    }
            )
        }
    }

    private fun executeRequestAsync(requestMessage: ExtendedHttpRequestMessage, isCheckinRequest: Boolean = false): CompletableFuture<Response> {
        setDefaultRequestHeaders(requestMessage)

        return httpClient!!.executeRequest(requestMessage).toCompletableFuture().thenApply {
            if (it.statusCode !in 200..299)
                errorHandling(it, requestMessage, isCheckinRequest)

            return@thenApply it
        }
    }

    private fun preExecuteRequest(request: IRequest) {
        validateRequest(request)
        setupHttpClient()
    }

    private fun validateRequest(request: IRequest) {
        request.validate()
    }

    private fun setupHttpClient() {
        if (httpClient == null)
            httpClient = asyncHttpClient()
    }

    private fun setDefaultRequestHeaders(requestMessage: ExtendedHttpRequestMessage) {
        requestMessage.setHeader(Constants.API_CLIENT_ID_HEADER_KEY, client.clientId)
        requestMessage.setHeader(Constants.API_VERSION_HEADER_KEY, "${client.configuration.apiVersion}")

        requestMessage.setHeader("Accept", Constants.MEDIA_TYPE)
        requestMessage.setHeader("Content-Type", Constants.MEDIA_TYPE)
    }

    private fun errorHandling(httpResponse: Response, requestMessage: ExtendedHttpRequestMessage, isCheckinRequest: Boolean = false) {
        var responseContent = ""

        if (httpResponse.responseBody != null)
            responseContent = httpResponse.responseBody

        val code = httpResponse.statusCode
        val url = requestMessage.url
        val requestBodyJson = requestMessage.requestBodyJson
        val reasonPhrase = httpResponse.statusText

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

    companion object {
        var httpClient: AsyncHttpClient? = null
    }
}
