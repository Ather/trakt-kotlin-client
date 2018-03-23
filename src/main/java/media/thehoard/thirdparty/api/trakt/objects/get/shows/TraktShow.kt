package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl

interface TraktShow {
    var title: String

    var year: Int?

    var ids: TraktShowIdsImpl
}
