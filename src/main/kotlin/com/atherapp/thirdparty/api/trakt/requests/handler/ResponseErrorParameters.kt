package com.atherapp.thirdparty.api.trakt.requests.handler

import com.atherapp.thirdparty.api.trakt.requests.base.RequestObjectType

internal data class ResponseErrorParameters(
        val url: String,
        val requestBody: String,
        val responseBody: String,
        val serverReasonPhrase: String,
        val statusCode: Int,
        val requestObjectType: RequestObjectType,
        val objectId: String,
        val seasonNumber: Int,
        val episodeNumber: Int,
        val isCheckinRequest: Boolean,
        val isDeviceRequest: Boolean,
        val isInAuthorizationPolling: Boolean,
        val isAuthorizationRequest: Boolean,
        val isAuthorizationRevoke: Boolean
)