package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktBoxOfficeMovie

data class TraktBoxOfficeMovieImpl(override var revenue: Long? = null,
                                   override var movie: TraktMovieImpl = TraktMovieImpl()) : TraktBoxOfficeMovie {
    override var title: String
        get() = movie.title
        set(title) {
            movie.title = title
        }
    override var year: Int?
        get() = movie.year
        set(year) {
            movie.year = year
        }
    override var ids: TraktMovieIdsImpl
        get() = movie.ids
        set(ids) {
            movie.ids = ids
        }
}
