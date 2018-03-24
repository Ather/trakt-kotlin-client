package media.thehoard.thirdparty.api.trakt.objects.get.seasons

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeCollectionProgressImpl

interface TraktSeasonCollectionProgress : TraktSeasonProgress {
    var episodes: MutableList<TraktEpisodeCollectionProgressImpl>
}
