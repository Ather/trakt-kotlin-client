package media.thehoard.thirdparty.api.trakt.objects.get.watched

interface TraktWatchedShowSeason {
    var number: Int?

    var episodes: MutableList<TraktWatchedShowEpisode>

}
