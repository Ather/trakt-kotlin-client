package media.thehoard.thirdparty.api.trakt.objects.get.collections

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktCollectionShow : TraktShow {
    var lastCollectedAt: ZonedDateTime?

    var show: TraktShow

    var seasons: MutableList<TraktCollectionShowSeason>

}
