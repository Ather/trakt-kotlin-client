package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsRemovePostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl

data class TraktSyncRatingsRemovePostResponseImpl(
        override var deleted: TraktSyncPostResponseGroupImpl = TraktSyncPostResponseGroupImpl(),
        @SerializedName("not_found")
        override var notFound: TraktSyncPostResponseNotFoundGroupImpl = TraktSyncPostResponseNotFoundGroupImpl()
) : TraktSyncRatingsRemovePostResponse
