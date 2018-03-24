package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.implementations

import media.thehoard.thirdparty.api.trakt.enums.TraktScrobbleActionType
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses.TraktEpisodeScrobblePostResponse

class TraktEpisodeScrobblePostResponseImpl(
        override var id: Long = 0,
        override var action: TraktScrobbleActionType = TraktScrobbleActionType.UNSPECIFIED,
        override var progress: Float? = null,
        override var sharing: TraktSharingImpl = TraktSharingImpl(),
        override var episode: TraktEpisodeImpl = TraktEpisodeImpl(),
        override var show: TraktShowImpl? = null
) : TraktEpisodeScrobblePostResponse
