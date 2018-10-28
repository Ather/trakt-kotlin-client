package com.atherapp.thirdparty.api.trakt.requests.handler

import com.atherapp.thirdparty.api.trakt.exceptions.*
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktError
import com.atherapp.thirdparty.api.trakt.objects.basic.implementations.TraktErrorImpl
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.TraktCheckinPostErrorResponse
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.implementations.TraktCheckinPostErrorResponseImpl
import com.atherapp.thirdparty.api.trakt.requests.base.RequestObjectType.*
import com.atherapp.thirdparty.api.trakt.utils.Json
import com.github.kittinunf.fuel.core.Response
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.HttpURLConnection.*
import java.nio.charset.Charset

internal fun <T : TraktException> T.init(errorParameters: ResponseErrorParameters): T {
    requestUrl = errorParameters.url
    requestBody = errorParameters.requestBody
    response = errorParameters.responseBody
    serverReasonPhrase = errorParameters.serverReasonPhrase
    return this
}

internal fun <T : TraktException> T.initHttp(errorParameters: ResponseErrorParameters): T {
    this.init(errorParameters)
    statusCode = errorParameters.statusCode
    return this
}

internal object ResponseErrorHandler {
    fun handleErrorsAsync(
            requestMessage: ExtendedHttpRequestMessage,
            responseMessage: Response,
            isCheckinRequest: Boolean = false,
            isDeviceRequest: Boolean = false,
            isInAuthorizationPolling: Boolean = false,
            isAuthorizationRequest: Boolean = false,
            isAuthorizationRevoke: Boolean = false
    ): Deferred<Unit> = GlobalScope.async {
        val responseContent = responseMessage.data.toString(Charset.forName("UTF-8"))

        val errorParameters = ResponseErrorParameters(
                requestMessage.request.url.toString(),
                requestMessage.requestBodyJson,
                responseContent,
                responseMessage.responseMessage,
                responseMessage.statusCode,
                requestMessage.requestObjectType ?: Unspecified,
                requestMessage.objectId,
                requestMessage.seasonNumber ?: 0,
                requestMessage.episodeNumber ?: 0,
                isCheckinRequest,
                isDeviceRequest,
                isInAuthorizationPolling,
                isAuthorizationRequest,
                isAuthorizationRevoke
        )

        handleErrorsAsync(errorParameters).await()
    }

    private fun handleErrorsAsync(errorParameters: ResponseErrorParameters): Deferred<Unit> = GlobalScope.async {
        when (errorParameters.statusCode) {
            HTTP_NOT_FOUND -> handleNotFoundError(errorParameters)
            HTTP_CONFLICT -> handleConflictError(errorParameters)
            HTTP_BAD_REQUEST -> handleBadRequestError(errorParameters)
            HTTP_UNAUTHORIZED -> handleUnauthorizedError(errorParameters)
            HTTP_FORBIDDEN -> handleForbiddenError(errorParameters)
            HTTP_BAD_METHOD -> handleMethodNotAllowedError(errorParameters)
            HTTP_GONE -> handleGoneError(errorParameters)
            HTTP_INTERNAL_ERROR -> handleInternalServerError(errorParameters)
            HTTP_BAD_GATEWAY -> handleBadGatewayError(errorParameters)
            HTTP_PRECON_FAILED -> handlePreconditionError(errorParameters)
            418 -> handleDeniedError(errorParameters)
            422 -> handleValidationError(errorParameters)
            429 -> handleRateLimitError(errorParameters)
            HTTP_UNAVAILABLE, HTTP_GATEWAY_TIMEOUT -> handleServerOverloadedError(errorParameters)
            520, 521, 522 -> handleCloudflareError(errorParameters)
        }
        return@async
    }

    private fun handleNotFoundError(errorParameters: ResponseErrorParameters): Nothing = errorParameters.run {
        if (isDeviceRequest || isInAuthorizationPolling) {
            throw TraktAuthenticationDeviceException("Not Found - invalid device code").initHttp(errorParameters)
        } else if (isAuthorizationRequest) {
            throw TraktAuthenticationOAuthException("Resource not found").initHttp(errorParameters)
        } else if (isAuthorizationRevoke) {
            throw TraktAuthenticationException("Resource not found").initHttp(errorParameters)
        } else if (requestObjectType != Unspecified && !isDeviceRequest && !isInAuthorizationPolling && !isAuthorizationRequest && !isAuthorizationRevoke)
            handleNotFoundObjectError(errorParameters)

        throw TraktNotFoundException("Resource not found - Reason Phrase: $serverReasonPhrase").init(errorParameters)
    }

    private fun handleNotFoundObjectError(errorParameters: ResponseErrorParameters) = errorParameters.run {
        when (requestObjectType) {
            Movies -> TraktMovieNotFoundException(objectId).init(errorParameters)
            Shows -> TraktShowNotFoundException(objectId).init(errorParameters)
            Seasons -> TraktSeasonNotFoundException(objectId, seasonNumber).init(errorParameters)
            Episodes -> TraktEpisodeNotFoundException(objectId, seasonNumber, episodeNumber).init(errorParameters)
            People -> TraktPersonNotFoundException(objectId).init(errorParameters)
            Comments -> TraktCommentNotFoundException(objectId).init(errorParameters)
            Lists -> TraktListNotFoundException(objectId).init(errorParameters)
            else -> return@run
        }
    }

    private fun handleConflictError(errorParameters: ResponseErrorParameters): Nothing {
        if (errorParameters.isCheckinRequest) {
            var errorResponse: TraktCheckinPostErrorResponse? = null
            if (errorParameters.responseBody.isNotBlank())
                errorResponse = Json.deserialize<TraktCheckinPostErrorResponseImpl>(errorParameters.responseBody)

            throw TraktCheckinException("check-in is already in progress").init(errorParameters).apply { expiresAt = errorResponse?.expiresAt }
        } else if (errorParameters.isInAuthorizationPolling)
            throw TraktAuthenticationDeviceException("Already Used - user already approved this code").initHttp(errorParameters)

        throw TraktConflictException().init(errorParameters)
    }

    private fun handleBadRequestError(errorParameters: ResponseErrorParameters) {
        if (!errorParameters.isInAuthorizationPolling)
            throw TraktBadRequestException().init(errorParameters)
    }

    private fun handleUnauthorizedError(errorParameters: ResponseErrorParameters) {
        if (!errorParameters.isAuthorizationRequest && !errorParameters.isAuthorizationRevoke)
            throw TraktAuthorizationException().init(errorParameters)
    }

    private fun handleForbiddenError(errorParameters: ResponseErrorParameters) {
        throw TraktForbiddenException().init(errorParameters)
    }

    private fun handleMethodNotAllowedError(errorParameters: ResponseErrorParameters) {
        throw TraktMethodNotFoundException().init(errorParameters)
    }

    private fun handleGoneError(errorParameters: ResponseErrorParameters) {
        if (errorParameters.isInAuthorizationPolling)
            throw TraktAuthenticationDeviceException("Expired - the tokens have expired, restart the process").initHttp(errorParameters)
    }

    private fun handleInternalServerError(errorParameters: ResponseErrorParameters) {
        throw TraktServerException().init(errorParameters)
    }

    private fun handleBadGatewayError(errorParameters: ResponseErrorParameters) {
        throw TraktBadGatewayException().init(errorParameters)
    }

    private fun handlePreconditionError(errorParameters: ResponseErrorParameters) {
        throw TraktPreconditionFailedException().init(errorParameters)
    }

    private fun handleDeniedError(errorParameters: ResponseErrorParameters) {
        if (errorParameters.isInAuthorizationPolling)
            throw TraktAuthenticationDeviceException("Denied - user explicitly denied this code").initHttp(errorParameters)
    }

    private fun handleValidationError(errorParameters: ResponseErrorParameters) {
        throw TraktValidationException().init(errorParameters)
    }

    private fun handleRateLimitError(errorParameters: ResponseErrorParameters) {
        if (errorParameters.isInAuthorizationPolling)
            throw TraktAuthenticationDeviceException("Slow down - your app is polling too quickly").initHttp(errorParameters)

        throw TraktRateLimitException().init(errorParameters)
    }

    private fun handleServerOverloadedError(errorParameters: ResponseErrorParameters) {
        throw TraktServerUnavailableException("Service Unavailable - server overloaded (try again in 30s)").initHttp(errorParameters)
    }

    private fun handleCloudflareError(errorParameters: ResponseErrorParameters) {
        throw TraktServerUnavailableException("Service Unavailable - Cloudflare error").initHttp(errorParameters)
    }

    private fun handleUnknownError(errorParameters: ResponseErrorParameters) {
        if (errorParameters.isDeviceRequest || errorParameters.isInAuthorizationPolling)
            throw TraktAuthenticationDeviceException("unknown exception").initHttp(errorParameters)
        else if (errorParameters.isAuthorizationRequest)
            throw TraktAuthenticationOAuthException("unknown exception").initHttp(errorParameters)
        else if (errorParameters.isAuthorizationRevoke)
            throw TraktAuthenticationException("unknown exception").initHttp(errorParameters)

        var error: TraktError? = null

        try {
            error = Json.deserialize<TraktErrorImpl>(errorParameters.responseBody)
        } catch (e: Exception) {
            throw TraktException("json convert exception", e)
        }

        val errorMessage = if (error.description.isBlank()) "Trakt API error without content. Response status code was ${errorParameters.statusCode}" else error.description

        throw TraktException(errorMessage).initHttp(errorParameters)
    }
}