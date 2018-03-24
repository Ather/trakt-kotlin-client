package media.thehoard.thirdparty.api.trakt.objects.get.seasons

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl

interface TraktSeasonExtendedEpisodes : TraktSeason {
    var episodes: List<TraktEpisodeImpl>
}