package media.thehoard.thirdparty.api.trakt.objects.get.shows

interface TraktTrendingShow : TraktShow {
    var watchers: Int?

    val show: TraktShow
}
