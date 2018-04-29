package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostShowEpisode

data class TraktSyncCollectionPostShowEpisodeImpl(
        override var number: Int
) : TraktSyncCollectionPostShowEpisode