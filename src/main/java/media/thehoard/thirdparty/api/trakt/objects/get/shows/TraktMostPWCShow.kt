package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

interface TraktMostPWCShow : TraktShow {
    var watcherCount: Int?

    var playCount: Int?

    var collectedCount: Int?

    var collectorCount: Int?

    var show: TraktShowImpl
}
