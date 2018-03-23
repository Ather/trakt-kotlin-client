package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

data class TraktShowImpl(override var title: String = "",
                         override var year: Int? = null,
                         override var ids: TraktShowIdsImpl = TraktShowIdsImpl()) : TraktShow