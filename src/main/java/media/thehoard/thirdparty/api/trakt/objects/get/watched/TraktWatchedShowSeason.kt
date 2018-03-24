package media.thehoard.thirdparty.api.trakt.objects.get.watched

import media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations.TraktWatchedShowEpisodeImpl

interface TraktWatchedShowSeason {
    var number: Int?

    var episodes: MutableList<TraktWatchedShowEpisodeImpl>

}
