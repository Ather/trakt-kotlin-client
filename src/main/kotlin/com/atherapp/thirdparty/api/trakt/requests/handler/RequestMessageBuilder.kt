package com.atherapp.thirdparty.api.trakt.requests.handler

import com.damnhandy.uri.template.UriTemplate
import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.core.Constants
import com.atherapp.thirdparty.api.trakt.exceptions.TraktAuthorizationException
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.requests.base.AuthorizationRequirement
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IHasId
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody
import com.atherapp.thirdparty.api.trakt.requests.interfaces.base.IRequest
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Method

internal class RequestMessageBuilder(
        private val client: TraktClient,
        var request: IRequest? = null,
        var authorization: TraktAuthorization = client.authorization
) {
    var requestBody: IRequestBody? = null

    var useAPIVersionHeader = true
    var useAPIClientIdHeader = true

    fun withRequestBody(requestBody: IRequestBody?): RequestMessageBuilder {
        this.requestBody = requestBody
        return this
    }

    fun withAuthorization(requestAuthorization: TraktAuthorization): RequestMessageBuilder {
        this.authorization = requestAuthorization
        return this
    }

    fun reset(request: IRequest): RequestMessageBuilder {
        this.request = request
        this.requestBody = null
        return this
    }

    fun build(): ExtendedHttpRequestMessage {
        val requestMessage = createRequestMessage()
        addRequestBodyContent(requestMessage)
        setRequestMessageHeadersForAuthorization(requestMessage)
        return requestMessage
    }

    private fun createRequestMessage(): ExtendedHttpRequestMessage {
        val url = buildUrl()

        val requestMessage = ExtendedHttpRequestMessage(Fuel.request(Method.valueOf(request!!.method.toString()), url))

        if (request is IHasId) {
            val idRequest = request as IHasId
            requestMessage.objectId = idRequest.id
            requestMessage.requestObjectType = idRequest.requestObjectType
        }

        val requestUriParameters = request!!.uriPathParameters

        if (requestUriParameters?.isNotEmpty() == true) {
            if (requestUriParameters.containsKey(SEASON_KEY)) {
                val strSeasonNumber: String = requestUriParameters[SEASON_KEY] as String
                try {
                    val seasonNumber = strSeasonNumber.toInt()
                    requestMessage.seasonNumber = seasonNumber
                } catch (e: NumberFormatException) {
                }
            }

            if (requestUriParameters.containsKey(EPISODE_KEY)) {
                val strEpisodeNumber: String = requestUriParameters[EPISODE_KEY] as String
                try {
                    val episodeNumber = strEpisodeNumber.toInt()
                    requestMessage.episodeNumber = episodeNumber
                } catch (e: NumberFormatException) {
                }
            }
        }

        return requestMessage
    }

    private fun buildUrl(): String {
        val uriTemplate = UriTemplate.fromTemplate(request!!.uriTemplate)

        for ((key, value) in request!!.uriPathParameters!!)
            uriTemplate.set(key, value)

        return client.configuration.baseUrl + uriTemplate.expand()
    }

    private fun addRequestBodyContent(requestMessage: ExtendedHttpRequestMessage) {
        if (requestBody != null) {
            val json = requestBody!!.toJson()
            requestMessage.request.body(json)
            requestMessage.requestBodyJson = json
        }
    }

    private fun setRequestMessageHeadersForAuthorization(requestMessage: ExtendedHttpRequestMessage) {
        val authorizationRequirement = request!!.authorizationRequirement

        if (useAPIVersionHeader)
            requestMessage.request.header(Constants.API_VERSION_HEADER_KEY to "${client.configuration.apiVersion}")
        if (useAPIClientIdHeader && client.clientId != null)
            requestMessage.request.header(Constants.API_CLIENT_ID_HEADER_KEY to client.clientId!!)

        if (authorizationRequirement == AuthorizationRequirement.Required) {
            if (authorization.isExpired)
                throw TraktAuthorizationException("authorization is required for this request, but the current authorization parameters are invalid")
        } else if (authorizationRequirement == AuthorizationRequirement.Optional && client.configuration.forceAuthorization) {
            if (authorization.isExpired)
                throw TraktAuthorizationException("authorization is optional for this request, but forced and the current authorization parameters are invalid")
        }

        if (authorizationRequirement == AuthorizationRequirement.Required || authorizationRequirement == AuthorizationRequirement.Optional || client.configuration.forceAuthorization)
            requestMessage.request.header("Authorization" to "$AUTHENTICATION_SCHEME ${authorization.accessToken}")
    }

    companion object {
        const val AUTHENTICATION_SCHEME = "Bearer"
        const val SEASON_KEY = "season"
        const val EPISODE_KEY = "episode"
    }
}