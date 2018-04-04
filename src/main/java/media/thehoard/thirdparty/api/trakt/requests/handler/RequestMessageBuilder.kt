package media.thehoard.thirdparty.api.trakt.requests.handler

import com.damnhandy.uri.template.UriTemplate
import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.exceptions.TraktAuthorizationException
import media.thehoard.thirdparty.api.trakt.requests.base.AuthorizationRequirement
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody
import media.thehoard.thirdparty.api.trakt.requests.interfaces.base.IRequest

internal class RequestMessageBuilder(
        private val client: TraktClient,
        private var request: IRequest? = null
) {
    private var requestBody: IRequestBody? = null

    fun withRequestBody(requestBody: IRequestBody): RequestMessageBuilder {
        this.requestBody = requestBody
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

        val requestMessage = ExtendedHttpRequestMessage(request!!.method, url)
        requestMessage.url = url

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
            requestMessage.setBody(json)
            requestMessage.requestBodyJson = json
        }
    }

    private fun setRequestMessageHeadersForAuthorization(requestMessage: ExtendedHttpRequestMessage) {
        val authorizationRequirement = request!!.authorizationRequirement

        if (authorizationRequirement == AuthorizationRequirement.Required)
            if (!client.authentication.isAuthorized)
                throw TraktAuthorizationException("authorization is required for this request, but the current authorization parameters are invalid")
            else if (authorizationRequirement == AuthorizationRequirement.Optional && client.configuration.forceAuthorization)
                if (!client.authentication.isAuthorized)
                    throw TraktAuthorizationException("authorization is optional for this request, but forced and the current authorization parameters are invalid")

        requestMessage.setHeader("Authorization", "$AUTHENTICATION_SCHEME ${client.authentication.authorization.accessToken}")
    }

    companion object {
        const val AUTHENTICATION_SCHEME = "Bearer"
        const val SEASON_KEY = "season"
        const val EPISODE_KEY = "episode"
    }
}