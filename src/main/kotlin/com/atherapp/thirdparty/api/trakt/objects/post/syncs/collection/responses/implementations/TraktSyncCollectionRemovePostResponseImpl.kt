package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.responses.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.responses.TraktSyncCollectionRemovePostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl

data class TraktSyncCollectionRemovePostResponseImpl(
        override var deleted: TraktSyncPostResponseGroupImpl = TraktSyncPostResponseGroupImpl(),
        @SerializedName("not_found")
        override var notFound: TraktSyncPostResponseNotFoundGroupImpl = TraktSyncPostResponseNotFoundGroupImpl()
) : TraktSyncCollectionRemovePostResponse
