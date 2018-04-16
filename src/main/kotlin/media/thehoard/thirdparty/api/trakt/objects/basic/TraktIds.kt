package media.thehoard.thirdparty.api.trakt.objects.basic

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds

interface TraktIds : TraktDefaultIds {
    var trakt: Int

    var slug: String

    var tvdb: Int?

    var imdb: String

    var tmdb: Int?
}
