package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason

interface TraktShowProgress {
    var aired: Int?

    var completed: Int?

    var hiddenSeasons: MutableList<TraktSeason>

    var nextEpisode: TraktEpisode

    var lastEpisode: TraktEpisode
}
