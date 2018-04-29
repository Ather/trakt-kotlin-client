package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection

import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktSyncCollectionPost : IRequestBody {
    var movies: MutableList<TraktSyncCollectionPostMovie>

    var shows: MutableList<TraktSyncCollectionPostShow>

    var episodes: MutableList<TraktSyncCollectionPostEpisode>
}