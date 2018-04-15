package media.thehoard.thirdparty.api.trakt.objects.get.movies

interface TraktTrendingMovie : TraktMovie {
    var watchers: Int?

    var movie: TraktMovie

}
