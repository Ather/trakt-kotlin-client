package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.*

data class TraktUserStatisticsImpl(
        override var movies: TraktUserMoviesStatistics = TraktUserMoviesStatisticsImpl(),
        override var shows: TraktUserShowsStatistics = TraktUserShowsStatisticsImpl(),
        override var seasons: TraktUserSeasonsStatistics = TraktUserSeasonsStatisticsImpl(),
        override var episodes: TraktUserEpisodesStatistics = TraktUserEpisodesStatisticsImpl(),
        override var network: TraktUserNetworkStatistics = TraktUserNetworkStatisticsImpl(),
        override var ratings: TraktUserRatingsStatistics = TraktUserRatingsStatisticsImpl()
) : TraktUserStatistics
