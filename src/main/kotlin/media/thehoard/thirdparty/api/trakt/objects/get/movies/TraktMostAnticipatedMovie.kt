package media.thehoard.thirdparty.api.trakt.objects.get.movies

interface TraktMostAnticipatedMovie : TraktMovie {
    var listCount: Int?

    var movie: TraktMovie
}
