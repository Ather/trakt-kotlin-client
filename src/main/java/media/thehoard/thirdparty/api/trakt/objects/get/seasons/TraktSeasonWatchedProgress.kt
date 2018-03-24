package media.thehoard.thirdparty.api.trakt.objects.get.seasons

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeWatchedProgressImpl

interface TraktSeasonWatchedProgress : TraktSeasonProgress {
    var episodes: MutableList<TraktEpisodeWatchedProgressImpl>

}
