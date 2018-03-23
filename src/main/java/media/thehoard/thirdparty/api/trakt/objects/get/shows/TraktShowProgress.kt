package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl

interface TraktShowProgress {
    var aired: Int?

    var completed: Int?

    var hiddenSeasons: List<TraktSeasonImpl>

    val nextEpisode: TraktEpisodeImpl

    val lastEpisode: TraktEpisodeImpl
}
