package com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses

interface TraktSyncPostResponseGroup {
    var movies: Int?
    var shows: Int?
    var seasons: Int?
    var episodes: Int?
}