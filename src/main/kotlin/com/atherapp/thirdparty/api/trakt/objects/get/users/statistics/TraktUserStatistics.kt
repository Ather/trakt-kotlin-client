package com.atherapp.thirdparty.api.trakt.objects.get.users.statistics

interface TraktUserStatistics {
    var movies: TraktUserMoviesStatistics

    var shows: TraktUserShowsStatistics

    var seasons: TraktUserSeasonsStatistics

    var episodes: TraktUserEpisodesStatistics

    var network: TraktUserNetworkStatistics

    var ratings: TraktUserRatingsStatistics

}
