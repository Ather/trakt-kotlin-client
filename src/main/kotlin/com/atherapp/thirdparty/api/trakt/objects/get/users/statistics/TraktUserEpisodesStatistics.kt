package com.atherapp.thirdparty.api.trakt.objects.get.users.statistics

interface TraktUserEpisodesStatistics {
    var plays: Int?

    var watched: Int?

    var minutes: Int?

    var collected: Int?

    var ratings: Int?

    var comments: Int?

}
