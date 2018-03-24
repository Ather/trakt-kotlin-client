package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.TraktUserSeasonsStatistics

data class TraktUserSeasonsStatisticsImpl(
        override var ratings: Int? = null,
        override var comments: Int? = null
) : TraktUserSeasonsStatistics
