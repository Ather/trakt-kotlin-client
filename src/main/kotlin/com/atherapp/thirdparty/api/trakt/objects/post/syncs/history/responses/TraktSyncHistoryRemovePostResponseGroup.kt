package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseGroup

interface TraktSyncHistoryRemovePostResponseGroup : TraktSyncPostResponseGroup {
    var ids: Int?
}