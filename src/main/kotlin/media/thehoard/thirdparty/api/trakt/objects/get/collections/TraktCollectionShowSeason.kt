package media.thehoard.thirdparty.api.trakt.objects.get.collections

interface TraktCollectionShowSeason {
    var number: Int?

    var episodes: MutableList<TraktCollectionShowEpisode>

}
