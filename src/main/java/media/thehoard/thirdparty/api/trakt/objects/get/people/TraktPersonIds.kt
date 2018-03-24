package media.thehoard.thirdparty.api.trakt.objects.get.people

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonIdsImpl

interface TraktPersonIds : TraktDefaultIds {
    var trakt: Int

    var slug: String

    var imdb: String

    var tmdb: Int?

}
