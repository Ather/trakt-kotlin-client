package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

import java.util.Date

interface TraktRecentlyUpdatedMovie : TraktMovie {
    var updatedAt: Date?

    var movie: TraktMovieImpl

}
