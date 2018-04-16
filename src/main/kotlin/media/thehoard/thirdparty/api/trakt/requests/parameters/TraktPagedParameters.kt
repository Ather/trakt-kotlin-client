package media.thehoard.thirdparty.api.trakt.requests.parameters

data class TraktPagedParameters(
        var page: Int? = null,
        var limit: Int? = null
)