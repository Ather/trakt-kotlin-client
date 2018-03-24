package media.thehoard.thirdparty.api.trakt.objects.get.collections

import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

import java.time.Instant

interface TraktCollectionShow<EpisodeType : TraktCollectionShowEpisode> : TraktShow {
    var lastCollectedAt: Instant?

    var show: TraktShowImpl

    var seasons: List<TraktCollectionShowSeasonImpl<EpisodeType>>

}
