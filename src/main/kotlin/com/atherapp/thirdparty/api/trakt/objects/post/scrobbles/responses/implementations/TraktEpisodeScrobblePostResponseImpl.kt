package com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.responses.implementations

import com.atherapp.thirdparty.api.trakt.enums.TraktScrobbleActionType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.post.scrobbles.responses.TraktEpisodeScrobblePostResponse

class TraktEpisodeScrobblePostResponseImpl(
        override var id: Long = 0,
        override var action: TraktScrobbleActionType = TraktScrobbleActionType.UNSPECIFIED,
        override var progress: Float? = null,
        override var sharing: TraktSharing = TraktSharingImpl(),
        override var episode: TraktEpisode = TraktEpisodeImpl(),
        override var show: TraktShow? = null
) : TraktEpisodeScrobblePostResponse
