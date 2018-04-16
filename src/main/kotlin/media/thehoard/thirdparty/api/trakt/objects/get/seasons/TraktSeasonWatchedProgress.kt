package media.thehoard.thirdparty.api.trakt.objects.get.seasons

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeWatchedProgress

interface TraktSeasonWatchedProgress : TraktSeasonProgress {
    var episodes: MutableList<TraktEpisodeWatchedProgress>

}
