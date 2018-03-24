package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonCollectionProgressImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowCollectionProgress
import java.time.Instant

data class TraktShowCollectionProgressImpl(
        override var lastCollectedAt: Instant? = null,
        override var seasons: MutableList<TraktSeasonCollectionProgressImpl> = mutableListOf(),
        override var aired: Int? = null,
        override var completed: Int? = null,
        override var hiddenSeasons: MutableList<TraktSeasonImpl> = mutableListOf(),
        override var nextEpisode: TraktEpisodeImpl = TraktEpisodeImpl(),
        override var lastEpisode: TraktEpisodeImpl = TraktEpisodeImpl()
) : TraktShowCollectionProgress