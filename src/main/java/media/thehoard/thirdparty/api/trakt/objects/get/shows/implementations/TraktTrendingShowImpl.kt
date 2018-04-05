package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktTrendingShow

data class TraktTrendingShowImpl(
        override var watchers: Int? = null,
        override var show: TraktShowImpl = TraktShowImpl()
) : TraktTrendingShow, TraktShow by show