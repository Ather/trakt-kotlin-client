package media.thehoard.thirdparty.api.trakt.core

object Constants {
    const val API_URL = "https://api.trakt.tv/"
    const val API_STAGING_URL = "https://api-staging.trakt.tv/"

    const val API_CLIENT_ID_HEADER_KEY = "trakt-api-key"
    const val API_VERSION_HEADER_KEY = "trakt-api-version"

    const val OAUTH_BASE_AUTHORIZE_URL = "http://trakt.tv"
    const val OAUTH_BASE_AUTHORIZE_STAGING_URL = "https://staging.trakt.tv"

    const val OAUTH_AUTHORIZE_URI = "oauth/authorize"
    const val OAUTH_TOKEN_URI = "oauth/token"
    const val OAUTH_REVOKE_URL = "oauth/revoke"

    const val OAUTH_DEVICE_CODE_URI = "oauth/device/code"
    const val OAUTH_DEVICE_TOKEN_URI = "oauth/device/token"

    const val MEDIA_TYPE = "application/json"
}
