package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundEpisode
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundMovie
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundSeason
import com.atherapp.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundShow
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryRemovePostResponseNotFoundGroup

class TraktSyncHistoryRemovePostResponseNotFoundGroupImpl(
        override var ids: List<Long> = listOf(),
        override var movies: List<TraktPostResponseNotFoundMovie> = listOf(),
        override var shows: List<TraktPostResponseNotFoundShow> = listOf(),
        override var seasons: List<TraktPostResponseNotFoundSeason> = listOf(),
        override var episodes: List<TraktPostResponseNotFoundEpisode> = listOf()
) : TraktSyncHistoryRemovePostResponseNotFoundGroup
