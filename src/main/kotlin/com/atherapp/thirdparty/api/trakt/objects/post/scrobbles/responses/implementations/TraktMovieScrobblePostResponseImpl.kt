package com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.responses.implementations

import com.atherapp.thirdparty.api.trakt.enums.TraktScrobbleActionType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.responses.TraktMovieScrobblePostResponse

class TraktMovieScrobblePostResponseImpl(
        override var id: Long = 0,
        override var action: TraktScrobbleActionType = TraktScrobbleActionType.UNSPECIFIED,
        override var progress: Float? = null,
        override var sharing: TraktSharing = TraktSharingImpl(),
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktMovieScrobblePostResponse
