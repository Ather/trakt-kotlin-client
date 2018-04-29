package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.responses

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl

interface TraktSyncWatchlistRemovePostResponse {
    var deleted: TraktSyncPostResponseGroupImpl
    var notFound: TraktSyncPostResponseNotFoundGroupImpl
}