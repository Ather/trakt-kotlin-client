package media.thehoard.thirdparty.api.trakt.objects.get.seasons

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonIdsImpl

interface TraktSeason {
    var number: Int?

    var ids: TraktSeasonIdsImpl
}
