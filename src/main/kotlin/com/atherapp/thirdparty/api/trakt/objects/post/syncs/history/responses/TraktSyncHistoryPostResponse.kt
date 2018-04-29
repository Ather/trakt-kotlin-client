package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseGroup
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseNotFoundGroup

interface TraktSyncHistoryPostResponse {
    var added: TraktSyncPostResponseGroup
    var notFound: TraktSyncPostResponseNotFoundGroup
}