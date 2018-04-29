package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponseNotFoundGroup

data class TraktSyncRatingsPostResponseNotFoundGroupImpl(
        override var movies: MutableList<TraktSyncRatingsPostResponseNotFoundMovieImpl> = mutableListOf(),
        override var shows: MutableList<TraktSyncRatingsPostResponseNotFoundShowImpl> = mutableListOf(),
        override var seasons: MutableList<TraktSyncRatingsPostResponseNotFoundSeasonImpl> = mutableListOf(),
        override var episodes: MutableList<TraktSyncRatingsPostResponseNotFoundEpisodeImpl> = mutableListOf()
) : TraktSyncRatingsPostResponseNotFoundGroup
