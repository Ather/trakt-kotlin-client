package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseGroup
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseNotFoundGroup

interface TraktSyncHistoryRemovePostResponse {
    var deleted: TraktSyncPostResponseGroup
    var notFound: TraktSyncPostResponseNotFoundGroup
}