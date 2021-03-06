package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.responses.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.responses.TraktSyncCollectionPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl

data class TraktSyncCollectionPostResponseImpl(
        override var added: TraktSyncPostResponseGroupImpl = TraktSyncPostResponseGroupImpl(),
        override var updated: TraktSyncPostResponseGroupImpl = TraktSyncPostResponseGroupImpl(),
        override var existing: TraktSyncPostResponseGroupImpl = TraktSyncPostResponseGroupImpl(),
        @SerializedName("not_found")
        override var notFound: TraktSyncPostResponseNotFoundGroupImpl = TraktSyncPostResponseNotFoundGroupImpl()
) : TraktSyncCollectionPostResponse
