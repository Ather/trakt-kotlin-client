package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.TraktUserRatingsStatistics

data class TraktUserRatingsStatisticsImpl(
        override var total: Int? = null,
        override var distribution: Map<String, Int> = mapOf()
) : TraktUserRatingsStatistics
