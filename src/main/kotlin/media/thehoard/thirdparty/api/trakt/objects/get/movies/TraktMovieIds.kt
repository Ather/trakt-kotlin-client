package media.thehoard.thirdparty.api.trakt.objects.get.movies

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds

interface TraktMovieIds : TraktDefaultIds {
    var trakt: Int

    var slug: String

    var imdb: String

    var tmdb: Int?

}
