package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import com.atherapp.thirdparty.api.trakt.extensions.validate
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPost
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostEpisode
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostMovie
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostShow
import com.atherapp.thirdparty.api.trakt.utils.Json

data class TraktSyncRatingsPostImpl(
        override var movies: MutableList<TraktSyncRatingsPostMovie> = mutableListOf(),
        override var shows: MutableList<TraktSyncRatingsPostShow> = mutableListOf(),
        override var episodes: MutableList<TraktSyncRatingsPostEpisode> = mutableListOf()
) : TraktSyncRatingsPost {
    override fun toJson(): String = Json.serialize(this)

    override fun validate(variableName: String) = (movies.isNotEmpty() && shows.isNotEmpty() && episodes.isNotEmpty()).validate("no ratings items set", null)

    companion object {
        fun builder(): TraktSyncRatingsPostBuilder {
            return TraktSyncRatingsPostBuilder()
        }
    }
}