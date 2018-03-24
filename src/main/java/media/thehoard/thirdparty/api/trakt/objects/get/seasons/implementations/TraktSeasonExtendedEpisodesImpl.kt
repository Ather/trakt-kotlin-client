package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonExtendedEpisodes

data class TraktSeasonExtendedEpisodesImpl(
        override var number: Int? = null,
        override var ids: TraktSeasonIdsImpl = TraktSeasonIdsImpl(),
        override var episodes: MutableList<TraktEpisodeImpl> = mutableListOf()
) : TraktSeasonExtendedEpisodes {
    constructor(traktSeason: TraktSeason) : this(traktSeason.number, traktSeason.ids)
}