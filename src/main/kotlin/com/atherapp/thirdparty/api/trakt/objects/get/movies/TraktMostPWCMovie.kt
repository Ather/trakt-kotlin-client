package com.atherapp.thirdparty.api.trakt.objects.get.movies

interface TraktMostPWCMovie : TraktMovie {

    var watcherCount: Int?

    var playCount: Int?

    var collectedCount: Int?

    var movie: TraktMovie
}
