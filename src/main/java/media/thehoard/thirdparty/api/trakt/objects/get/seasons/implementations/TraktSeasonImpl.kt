package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason

data class TraktSeasonImpl(override var number: Int? = null,
                           override var ids: TraktSeasonIdsImpl = TraktSeasonIdsImpl()) : TraktSeason
