package com.atherapp.thirdparty.api.trakt.objects.basic

interface TraktStatistics {
    var watchers: Int?

    var plays: Int?

    var collectors: Int?

    var collectedEpisodes: Int?

    var comments: Int?

    var lists: Int?

    var votes: Int?
}
