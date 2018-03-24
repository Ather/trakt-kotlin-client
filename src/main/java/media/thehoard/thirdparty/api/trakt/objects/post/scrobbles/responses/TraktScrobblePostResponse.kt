package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses

import media.thehoard.thirdparty.api.trakt.enums.TraktScrobbleActionType
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl

interface TraktScrobblePostResponse {
    var id: Long

    var action: TraktScrobbleActionType

    var progress: Float?

    var sharing: TraktSharingImpl
}