package media.thehoard.thirdparty.api.trakt.requests.handler

import com.github.salomonbrys.kotson.fromJson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import jdk.incubator.http.HttpClient
import jdk.incubator.http.HttpResponse
import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.core.Constants
import media.thehoard.thirdparty.api.trakt.exceptions.*
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktError
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktErrorImpl
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktCheckinPostErrorResponse
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations.TraktCheckinPostErrorResponseImpl
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType.*
import media.thehoard.thirdparty.api.trakt.requests.checkins.CheckinRequest
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.*
import media.thehoard.thirdparty.api.trakt.responses.TraktListResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import media.thehoard.thirdparty.api.trakt.utils.Json
import java.net.HttpURLConnection

internal class RequestHandler(
        private val client: TraktClient,
        private val requestMessageBuilder: RequestMessageBuilder
) : IRequestHandler {

    override fun executeNoContentRequest(request: IRequest): TraktNoContentResponse {
        preExecuteRequest(request)
        return queryNoContent(requestMessageBuilder.reset(request).build())
    }

    override fun <TRequestBodyType : IRequestBody> executeNoContentRequest(request: IPostRequest<TRequestBodyType>): TraktNoContentResponse {
        preExecuteRequest(request)
        return queryNoContent(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).build())
    }

    override fun <TRequestBodyType : IRequestBody> executeNoContentRequest(request: IPutRequest<TRequestBodyType>): TraktNoContentResponse {
        preExecuteRequest(request)
        return queryNoContent(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).build())
    }

    override fun <TResponseContentType> executeSingleItemRequest(request: IRequestHasResponse<TResponseContentType>): TraktResponse<TResponseContentType> {
        preExecuteRequest(request)
        return querySingleItem(requestMessageBuilder.reset(request).build(), false)
    }

    override fun <TResponseContentType, TRequestBodyType : IRequestBody> executeSingleItemRequest(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>): TraktResponse<TResponseContentType> {
        preExecuteRequest(request)
        return querySingleItem(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).build(), request is CheckinRequest<TResponseContentType, TRequestBodyType>)
    }

    override fun <TResponseContentType, TRequestBodyType : IRequestBody> executeSingleItemRequest(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>): TraktResponse<TResponseContentType> {
        preExecuteRequest(request)
        return querySingleItem(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).build(), false)
    }

    override fun <TResponseContentType> executeListRequest(request: IRequestHasResponse<TResponseContentType>): TraktListResponse<TResponseContentType> {
        preExecuteRequest(request)
        return queryList(requestMessageBuilder.reset(request).build())
    }

    override fun <TResponseContentType, TRequestBodyType : IRequestBody> executeListRequest(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>): TraktListResponse<TResponseContentType> {
        preExecuteRequest(request)
        return queryList(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).build())
    }

    override fun <TResponseContentType, TRequestBodyType : IRequestBody> executeListRequest(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>): TraktListResponse<TResponseContentType> {
        preExecuteRequest(request)
        return queryList(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).build())
    }

    override fun <TResponseContentType> executePagedRequest(request: IRequestHasResponse<TResponseContentType>): TraktPagedResponse<TResponseContentType> {
        preExecuteRequest(request)
        return queryPagedList(requestMessageBuilder.reset(request).build())
    }

    override fun <TResponseContentType, TRequestBodyType : IRequestBody> executePagedRequest(request: IPostRequestHasResponse<TResponseContentType, TRequestBodyType>): TraktPagedResponse<TResponseContentType> {
        preExecuteRequest(request)
        return queryPagedList(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).build())
    }

    override fun <TResponseContentType, TRequestBodyType : IRequestBody> executePagedRequest(request: IPutRequestHasResponse<TResponseContentType, TRequestBodyType>): TraktPagedResponse<TResponseContentType> {
        preExecuteRequest(request)
        return queryPagedList(requestMessageBuilder.reset(request).withRequestBody(request.requestBody!!).build())
    }

    private fun queryNoContent(requestMessage: ExtendedHttpRequestMessage): TraktNoContentResponse {
        val httpResponse: HttpResponse<String>?

        return try {
            httpResponse = executeRequest(requestMessage, false)
            checkNotNull(httpResponse)
            check(httpResponse.statusCode() == HttpURLConnection.HTTP_NO_CONTENT)
            TraktNoContentResponse().apply { isSuccess = true }
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e

            TraktNoContentResponse().apply {
                isSuccess = false
                exception = e
            }
        }
    }

    private fun <TResponseContentType> querySingleItem(requestMessage: ExtendedHttpRequestMessage, isCheckinRequest: Boolean = false): TraktResponse<TResponseContentType> {
        val httpResponse: HttpResponse<String>?

        try {
            httpResponse = executeRequest(requestMessage, isCheckinRequest)
            checkNotNull(httpResponse)
            check(httpResponse.statusCode() != HttpURLConnection.HTTP_NO_CONTENT)
            val contentObject = Json.gson.fromJson<TResponseContentType>(httpResponse.body(), object : TypeToken<TResponseContentType>() {}.type)

            val response = TraktResponse<TResponseContentType>().apply {
                isSuccess = true
                hasValue = true
                value = contentObject
            }

            if (httpResponse.headers() != null)
                ResponseHeaderParser.parseResponseHeaderValues(response, httpResponse.headers())

            return response
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e

            return TraktResponse<TResponseContentType>().apply {
                isSuccess = false
                exception = e
            }
        }
    }

    private fun <TResponseContentType> queryList(requestMessage: ExtendedHttpRequestMessage): TraktListResponse<TResponseContentType> {
        val httpResponse: HttpResponse<String>?

        try {
            httpResponse = executeRequest(requestMessage, false)
            checkNotNull(httpResponse)
            check(httpResponse.statusCode() != HttpURLConnection.HTTP_NO_CONTENT)
            val contentObject = Json.gson.fromJson<MutableList<TResponseContentType>>(httpResponse.body())

            val response = TraktListResponse<TResponseContentType>().apply {
                isSuccess = true
                hasValue = true
                value = contentObject
            }

            if (httpResponse.headers() != null)
                ResponseHeaderParser.parseResponseHeaderValues(response, httpResponse.headers())

            return response
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e

            return TraktListResponse<TResponseContentType>().apply {
                isSuccess = false
                exception = e
            }
        }
    }

    private fun <TResponseContentType> queryPagedList(requestMessage: ExtendedHttpRequestMessage): TraktPagedResponse<TResponseContentType> {
        val httpResponse: HttpResponse<String>?

        try {
            httpResponse = executeRequest(requestMessage, false)
            checkNotNull(httpResponse)
            check(httpResponse.statusCode() != HttpURLConnection.HTTP_NO_CONTENT)
            val contentObject = Json.gson.fromJson<MutableList<TResponseContentType>>(httpResponse.body())

            val response = TraktPagedResponse<TResponseContentType>().apply {
                isSuccess = true
                hasValue = true
                value = contentObject
            }

            if (httpResponse.headers() != null)
                ResponseHeaderParser.parsePagedResponseHeaderValue(response, httpResponse.headers())

            return response
        } catch (e: Exception) {
            if (client.configuration.throwResponseExceptions)
                throw e

            return TraktPagedResponse<TResponseContentType>().apply {
                isSuccess = false
                exception = e
            }
        }
    }

    private fun executeRequest(requestMessage: ExtendedHttpRequestMessage, isCheckinRequest: Boolean = false): HttpResponse<String> {
        setDefaultRequestHeaders(requestMessage)
        val response = httpClient!!.send(requestMessage.build(), HttpResponse.BodyHandler.asString())
        if (response.statusCode() !in 200..299)
            errorHandling(response, requestMessage, isCheckinRequest)

        return response
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
            httpClient = HttpClient.newHttpClient()
    }

    private fun setDefaultRequestHeaders(requestMessage: ExtendedHttpRequestMessage) {
        requestMessage.header(Constants.API_CLIENT_ID_HEADER_KEY, client.clientId)
        requestMessage.header(Constants.API_VERSION_HEADER_KEY, "${client.configuration.apiVersion}")

        requestMessage.header("Accept", Constants.MEDIA_TYPE)
        requestMessage.headers("Content-type", Constants.MEDIA_TYPE)
    }

    private fun errorHandling(httpResponse: HttpResponse<String>, requestMessage: ExtendedHttpRequestMessage, isCheckinRequest: Boolean = false) {
        var responseContent = ""

        if (httpResponse.body() != null)
            responseContent = httpResponse.body()

        val code = httpResponse.statusCode()
        val url = requestMessage.url
        val requestBodyJson = requestMessage.requestBodyJson
        val reasonPhrase = ""

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
                    errorResponse = Json.gson.fromJson<TraktCheckinPostErrorResponseImpl>(responseContent)
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
            error = Json.gson.fromJson<TraktErrorImpl>(responseContent)
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
        var httpClient: HttpClient? = null
    }
}
