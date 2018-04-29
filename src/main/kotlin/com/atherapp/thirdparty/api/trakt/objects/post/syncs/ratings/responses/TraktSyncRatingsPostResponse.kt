package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl

interface TraktSyncRatingsPostResponse {
    var added: TraktSyncPostResponseGroupImpl
    var notFound: TraktSyncPostResponseNotFoundGroupImpl
}