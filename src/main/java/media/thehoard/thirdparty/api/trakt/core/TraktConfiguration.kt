package media.thehoard.thirdparty.api.trakt.core

class TraktConfiguration {
    var apiVersion = 2

    var useSandboxEnvironment: Boolean = false

    val baseUrl: String
        get() = if (useSandboxEnvironment) Constants.API_STAGING_URL else Constants.API_URL

    var forceAuthorization: Boolean = false

    var throwResponseExceptions = true
}
