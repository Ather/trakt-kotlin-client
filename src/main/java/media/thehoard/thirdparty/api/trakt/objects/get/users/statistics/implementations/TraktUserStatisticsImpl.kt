package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.TraktUserStatistics

data class TraktUserStatisticsImpl(
        override var movies: TraktUserMoviesStatisticsImpl = TraktUserMoviesStatisticsImpl(),
        override var shows: TraktUserShowsStatisticsImpl = TraktUserShowsStatisticsImpl(),
        override var seasons: TraktUserSeasonsStatisticsImpl = TraktUserSeasonsStatisticsImpl(),
        override var episodes: TraktUserEpisodesStatisticsImpl = TraktUserEpisodesStatisticsImpl(),
        override var network: TraktUserNetworkStatisticsImpl = TraktUserNetworkStatisticsImpl(),
        override var ratings: TraktUserRatingsStatisticsImpl = TraktUserRatingsStatisticsImpl()
) : TraktUserStatistics
