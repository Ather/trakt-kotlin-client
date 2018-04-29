package com.atherapp.thirdparty.api.trakt.objects.get.users.statistics

interface TraktUserRatingsStatistics {
    var total: Int?

    var distribution: Map<String, Int>

}
