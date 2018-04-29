package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings

import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktSyncRatingsPost : IRequestBody {
    var movies: MutableList<TraktSyncRatingsPostMovie>
    var shows: MutableList<TraktSyncRatingsPostShow>
    var episodes: MutableList<TraktSyncRatingsPostEpisode>
}