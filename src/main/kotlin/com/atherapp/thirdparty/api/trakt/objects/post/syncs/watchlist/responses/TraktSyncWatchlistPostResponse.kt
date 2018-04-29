package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.responses

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl

interface TraktSyncWatchlistPostResponse {
    var added: TraktSyncPostResponseGroupImpl
    var existing: TraktSyncPostResponseGroupImpl
    var notFound: TraktSyncPostResponseNotFoundGroupImpl
}