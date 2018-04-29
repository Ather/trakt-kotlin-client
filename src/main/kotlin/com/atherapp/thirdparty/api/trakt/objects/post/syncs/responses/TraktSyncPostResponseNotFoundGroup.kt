package com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses

import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundEpisode
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundMovie
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundSeason
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundShow

interface TraktSyncPostResponseNotFoundGroup {
    var movies: List<TraktPostResponseNotFoundMovie>
    var shows: List<TraktPostResponseNotFoundShow>
    var seasons: List<TraktPostResponseNotFoundSeason>
    var episodes: List<TraktPostResponseNotFoundEpisode>
}