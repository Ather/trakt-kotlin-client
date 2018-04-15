package media.thehoard.thirdparty.api.trakt.objects.basic

import media.thehoard.thirdparty.api.trakt.enums.TraktGenreType

interface TraktGenre {
    var name: String

    var slug: String

    var type: TraktGenreType?
}
