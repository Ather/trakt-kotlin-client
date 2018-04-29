package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseGroup
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseNotFoundGroup
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl

class TraktSyncHistoryPostResponseImpl : TraktSyncHistoryPostResponse {
    override var added: TraktSyncPostResponseGroup = TraktSyncPostResponseGroupImpl()
    @SerializedName("not_found")
    override var notFound: TraktSyncPostResponseNotFoundGroup = TraktSyncPostResponseNotFoundGroupImpl()
}
