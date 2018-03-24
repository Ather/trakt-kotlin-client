package media.thehoard.thirdparty.api.trakt.objects.get.collections

interface TraktCollectionShowSeason<EpisodeType : TraktCollectionShowEpisode> {
    var number: Int?

    var episodes: List<EpisodeType>

}
