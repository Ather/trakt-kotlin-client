package media.thehoard.thirdparty.api.trakt.objects.get.shows

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

import java.time.Instant

interface TraktRecentlyUpdatedShow : TraktShow {
    var updatedAt: Instant?

    var show: TraktShowImpl
}