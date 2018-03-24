package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics

import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations.*

interface TraktUserStatistics {
    var movies: TraktUserMoviesStatisticsImpl

    var shows: TraktUserShowsStatisticsImpl

    var seasons: TraktUserSeasonsStatisticsImpl

    var episodes: TraktUserEpisodesStatisticsImpl

    var network: TraktUserNetworkStatisticsImpl

    var ratings: TraktUserRatingsStatisticsImpl

}
