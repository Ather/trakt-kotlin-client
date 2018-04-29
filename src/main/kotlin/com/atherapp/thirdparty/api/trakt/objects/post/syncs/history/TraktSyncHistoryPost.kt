package com.atherapp.thirdparty.api.trakt.objects.post.syncs.history

import com.atherapp.thirdparty.api.trakt.extensions.validate
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktSyncHistoryPost : IRequestBody {
    var movies: MutableList<TraktSyncHistoryPostMovie>
    var shows: MutableList<TraktSyncHistoryPostShow>
    var episodes: MutableList<TraktSyncHistoryPostEpisode>

    override fun validate(variableName: String) = (movies.isNotEmpty() && shows.isNotEmpty() && episodes.isNotEmpty()).validate("no history items set", null)
}