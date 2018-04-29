package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection

interface TraktSyncCollectionPostShowSeason {
    var number: Int

    var episodes: MutableList<TraktSyncCollectionPostShowEpisode>
}