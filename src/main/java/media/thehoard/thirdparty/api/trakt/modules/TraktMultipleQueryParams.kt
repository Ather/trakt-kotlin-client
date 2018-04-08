package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo

sealed class TraktMultipleQueryParams<T>(
        items: MutableList<T> = mutableListOf()
) : MutableList<T> by items {
    protected var items: MutableList<T> = items
        private set
}

class TraktMultipleEpisodesQueryParams : TraktMultipleQueryParams<TraktMultipleEpisodesQueryParams.TraktEpisodeQueryParams>() {
    fun add(showId: String, seasonNumber: Int, episodeNumber: Int, extendedInfo: TraktExtendedInfo? = null) =
            TraktEpisodeQueryParams(showId, seasonNumber, episodeNumber, extendedInfo)

    inner class TraktEpisodeQueryParams(
            val showId: String,
            val seasonNumber: Int,
            val episodeNumber: Int,
            val extendedInfo: TraktExtendedInfo?
    )
}

class TraktMultipleObjectsQueryParams : TraktMultipleQueryParams<TraktMultipleObjectsQueryParams.TraktObjectsQueryParams>() {
    fun add(idOrSlug: String, extendedInfo: TraktExtendedInfo? = null) =
            TraktObjectsQueryParams(idOrSlug, extendedInfo)

    inner class TraktObjectsQueryParams(
            val idOrSlug: String,
            val extendedInfo: TraktExtendedInfo?
    )
}

class TraktMultipleSeasonsQueryParams : TraktMultipleQueryParams<TraktMultipleSeasonsQueryParams.TraktSeasonsQueryParams>() {
    fun add(showId: String, seasonNumber: Int, extendedInfo: TraktExtendedInfo? = null, translationLanguageCode: String? = null) =
            TraktSeasonsQueryParams(showId, seasonNumber, extendedInfo, translationLanguageCode)

    inner class TraktSeasonsQueryParams(
            val showId: String,
            val seasonNumber: Int,
            val extendedInfo: TraktExtendedInfo?,
            val translationLanguageCode: String?
    )
}

class TraktMultipleUserListsQueryParams : TraktMultipleQueryParams<TraktMultipleUserListsQueryParams.TraktUserListsQueryParams>() {
    fun add(username: String, listId: String) =
            TraktUserListsQueryParams(username, listId)

    inner class TraktUserListsQueryParams(
            val username: String,
            val listId: String
    )
}