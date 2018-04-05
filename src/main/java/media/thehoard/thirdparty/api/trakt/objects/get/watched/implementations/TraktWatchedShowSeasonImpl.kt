package media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShowSeason

data class TraktWatchedShowSeasonImpl(
        override var number: Int? = null,
        override var episodes: MutableList<TraktWatchedShowEpisodeImpl> = mutableListOf()
) : TraktWatchedShowSeason