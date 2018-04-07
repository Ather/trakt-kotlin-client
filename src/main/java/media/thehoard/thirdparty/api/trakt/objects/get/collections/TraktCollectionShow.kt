package media.thehoard.thirdparty.api.trakt.objects.get.collections

import media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations.TraktCollectionShowSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

interface TraktCollectionShow : TraktShow {
    var lastCollectedAt: ZonedDateTime?

    var show: TraktShowImpl

    var seasons: MutableList<TraktCollectionShowSeasonImpl>

}
