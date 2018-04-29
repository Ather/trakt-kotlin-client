package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostShowEpisode
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostShowSeason

data class TraktSyncCollectionPostShowSeasonImpl(
        override var number: Int = 0,
        override var episodes: MutableList<TraktSyncCollectionPostShowEpisode> = mutableListOf()
) : TraktSyncCollectionPostShowSeason
