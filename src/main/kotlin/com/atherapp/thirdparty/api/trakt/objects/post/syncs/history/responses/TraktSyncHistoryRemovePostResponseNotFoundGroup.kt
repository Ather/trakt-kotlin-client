package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseNotFoundGroup

interface TraktSyncHistoryRemovePostResponseNotFoundGroup : TraktSyncPostResponseNotFoundGroup {
    var ids: List<Long>
}