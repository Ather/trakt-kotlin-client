package com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseGroup

data class TraktSyncPostResponseGroupImpl(
        override var movies: Int? = null,
        override var shows: Int? = null,
        override var seasons: Int? = null,
        override var episodes: Int? = null
) : TraktSyncPostResponseGroup
