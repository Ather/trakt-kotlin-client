package media.thehoard.thirdparty.api.trakt.objects.get.movies

interface TraktMovie {
    var title: String

    var year: Int?

    var ids: TraktMovieIds
}
