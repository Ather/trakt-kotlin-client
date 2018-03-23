package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

interface TraktTrendingShow : TraktShow {
    var watchers: Int?

    val show: TraktShowImpl
}
