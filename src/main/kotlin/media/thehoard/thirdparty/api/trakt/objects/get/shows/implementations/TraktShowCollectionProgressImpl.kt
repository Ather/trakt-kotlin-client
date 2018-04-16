package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonCollectionProgress
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowCollectionProgress
import java.time.ZonedDateTime

data class TraktShowCollectionProgressImpl(
        override var lastCollectedAt: ZonedDateTime? = null,
        override var seasons: MutableList<TraktSeasonCollectionProgress> = mutableListOf(),
        override var aired: Int? = null,
        override var completed: Int? = null,
        override var hiddenSeasons: MutableList<TraktSeason> = mutableListOf(),
        override var nextEpisode: TraktEpisode = TraktEpisodeImpl(),
        override var lastEpisode: TraktEpisode = TraktEpisodeImpl()
) : TraktShowCollectionProgress