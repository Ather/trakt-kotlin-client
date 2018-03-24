package media.thehoard.thirdparty.api.trakt.objects.get.episodes

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds

interface TraktEpisodeIds : TraktDefaultIds {
    var trakt: Int

    var tvdb: Int?

    var imdb: String

    var tmdb: Int?

}
