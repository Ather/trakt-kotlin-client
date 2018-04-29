package com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations.TraktSyncRatingsPostResponseNotFoundEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations.TraktSyncRatingsPostResponseNotFoundMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations.TraktSyncRatingsPostResponseNotFoundSeasonImpl
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations.TraktSyncRatingsPostResponseNotFoundShowImpl

interface TraktSyncRatingsPostResponseNotFoundGroup {
    var movies: MutableList<TraktSyncRatingsPostResponseNotFoundMovieImpl>
    var shows: MutableList<TraktSyncRatingsPostResponseNotFoundShowImpl>
    var seasons: MutableList<TraktSyncRatingsPostResponseNotFoundSeasonImpl>
    var episodes: MutableList<TraktSyncRatingsPostResponseNotFoundEpisodeImpl>
}