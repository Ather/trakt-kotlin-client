package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostEpisode
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostMovie
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostShow
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryRemovePost
import com.atherapp.thirdparty.api.trakt.utils.Json

data class TraktSyncHistoryRemovePostImpl(
        override var movies: MutableList<TraktSyncHistoryPostMovie> = mutableListOf(),
        override var shows: MutableList<TraktSyncHistoryPostShow> = mutableListOf(),
        override var episodes: MutableList<TraktSyncHistoryPostEpisode> = mutableListOf(),
        override val ids: MutableList<Long> = mutableListOf()
) : TraktSyncHistoryRemovePost {
    override fun toJson(): String = Json.serialize(this)

    companion object {
        fun builder(): TraktSyncHistoryRemovePostBuilder {
            return TraktSyncHistoryRemovePostBuilder()
        }
    }
}

