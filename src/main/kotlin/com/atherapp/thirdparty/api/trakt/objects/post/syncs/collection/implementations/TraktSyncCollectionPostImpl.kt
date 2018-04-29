package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import com.atherapp.thirdparty.api.trakt.extensions.validate
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPost
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostEpisode
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostMovie
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostShow
import com.atherapp.thirdparty.api.trakt.utils.Json

data class TraktSyncCollectionPostImpl(
        override var movies: MutableList<TraktSyncCollectionPostMovie> = mutableListOf(),
        override var shows: MutableList<TraktSyncCollectionPostShow> = mutableListOf(),
        override var episodes: MutableList<TraktSyncCollectionPostEpisode> = mutableListOf()
) : TraktSyncCollectionPost {

    companion object {
        fun builder(): TraktSyncCollectionPostBuilderImpl = TraktSyncCollectionPostBuilderImpl()
    }

    override fun toJson(): String = Json.serialize(this)

    override fun validate(variableName: String) = (movies.isNotEmpty() && shows.isNotEmpty() && episodes.isNotEmpty()).validate("no collection items set", null)
}
