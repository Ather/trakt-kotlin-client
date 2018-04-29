package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.responses

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl

interface TraktSyncCollectionPostResponse {
    var added: TraktSyncPostResponseGroupImpl
    var updated: TraktSyncPostResponseGroupImpl
    var existing: TraktSyncPostResponseGroupImpl
    var notFound: TraktSyncPostResponseNotFoundGroupImpl
}