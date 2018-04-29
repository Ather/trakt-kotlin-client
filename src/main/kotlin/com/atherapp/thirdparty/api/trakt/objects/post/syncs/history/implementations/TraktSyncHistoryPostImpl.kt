package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPost
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostEpisode
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostMovie
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostShow
import com.atherapp.thirdparty.api.trakt.utils.Json

data class TraktSyncHistoryPostImpl(
        override var movies: MutableList<TraktSyncHistoryPostMovie> = mutableListOf(),
        override var shows: MutableList<TraktSyncHistoryPostShow> = mutableListOf(),
        override var episodes: MutableList<TraktSyncHistoryPostEpisode> = mutableListOf()
) : TraktSyncHistoryPost {

    override fun toJson(): String = Json.serialize(this)

    companion object {
        fun builder(): TraktSyncHistoryPostBuilderImpl {
            return TraktSyncHistoryPostBuilderImpl()
        }
    }
}

