package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

interface TraktMostAnticipiatedShow : TraktShow {
    var listCount: Int?

    var show: TraktShowImpl
}
