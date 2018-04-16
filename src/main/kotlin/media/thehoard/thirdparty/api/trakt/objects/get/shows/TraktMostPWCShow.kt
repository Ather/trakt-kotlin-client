package media.thehoard.thirdparty.api.trakt.objects.get.shows

interface TraktMostPWCShow : TraktShow {
    var watcherCount: Int?

    var playCount: Int?

    var collectedCount: Int?

    var collectorCount: Int?

    var show: TraktShow
}
