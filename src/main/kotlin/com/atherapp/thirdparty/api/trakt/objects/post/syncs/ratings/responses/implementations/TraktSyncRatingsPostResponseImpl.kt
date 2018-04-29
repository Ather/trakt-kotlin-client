package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl

data class TraktSyncRatingsPostResponseImpl(
        override var added: TraktSyncPostResponseGroupImpl = TraktSyncPostResponseGroupImpl(),
        @SerializedName("not_found")
        override var notFound: TraktSyncPostResponseNotFoundGroupImpl = TraktSyncPostResponseNotFoundGroupImpl()
) : TraktSyncRatingsPostResponse
