package media.thehoard.thirdparty.api.trakt.core

object Constants {
    val API_URL = "https://api.trakt.tv/"
    val API_STAGING_URL = "https://api-staging.trakt.tv/"

    val API_CLIENT_ID_HEADER_KEY = "trakt-api-key"
    val API_VERSION_HEADER_KEY = "trakt-api-version"

    val OAUTH_BASE_AUTHORIZE_URL = "http://trakt.tv"
    val OAUTH_BASE_AUTHORIZE_STAGING_URL = "https://staging.trakt.tv"

    val OAUTH_AUTHORIZE_URI = "oauth/authorize"
    val OAUTH_TOKEN_URI = "oauth/token"
    val OAUTH_REVOKE_URL = "oauth/revoke"

    val OAUTH_DEVICE_CODE_URI = "oauth/device/code"
    val OAUTH_DEVICE_TOKEN_URI = "oauth/device/token"
}
