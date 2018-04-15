package media.thehoard.thirdparty.api.trakt.objects.get.seasons

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeCollectionProgress

interface TraktSeasonCollectionProgress : TraktSeasonProgress {
    var episodes: MutableList<TraktEpisodeCollectionProgress>
}
