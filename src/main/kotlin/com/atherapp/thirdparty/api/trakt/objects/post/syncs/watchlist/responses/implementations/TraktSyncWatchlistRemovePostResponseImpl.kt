package com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.TraktSyncWatchlistRemovePostResponse

data class TraktSyncWatchlistRemovePostResponseImpl(
        override var deleted: TraktSyncPostResponseGroupImpl = TraktSyncPostResponseGroupImpl(),
        @SerializedName("not_found")
        override var notFound: TraktSyncPostResponseNotFoundGroupImpl = TraktSyncPostResponseNotFoundGroupImpl()
) : TraktSyncWatchlistRemovePostResponse
