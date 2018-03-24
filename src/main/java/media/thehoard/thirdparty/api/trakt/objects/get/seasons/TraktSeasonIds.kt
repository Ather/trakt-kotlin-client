package media.thehoard.thirdparty.api.trakt.objects.get.seasons

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds

interface TraktSeasonIds : TraktDefaultIds {
    var trakt: Int

    var tvdb: Int?

    var tmdb: Int?

}
