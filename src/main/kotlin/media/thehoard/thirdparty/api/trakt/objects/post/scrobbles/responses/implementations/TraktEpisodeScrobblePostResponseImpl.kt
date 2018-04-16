package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.implementations

import media.thehoard.thirdparty.api.trakt.enums.TraktScrobbleActionType
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.TraktEpisodeScrobblePostResponse

class TraktEpisodeScrobblePostResponseImpl(
        override var id: Long = 0,
        override var action: TraktScrobbleActionType = TraktScrobbleActionType.UNSPECIFIED,
        override var progress: Float? = null,
        override var sharing: TraktSharing = TraktSharingImpl(),
        override var episode: TraktEpisode = TraktEpisodeImpl(),
        override var show: TraktShow? = null
) : TraktEpisodeScrobblePostResponse
