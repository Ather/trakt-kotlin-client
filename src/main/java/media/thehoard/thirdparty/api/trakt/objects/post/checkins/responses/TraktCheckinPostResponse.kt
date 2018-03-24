package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl

import java.time.Instant
import java.util.Date

interface TraktCheckinPostResponse {
    var id: Long

    var watchedAt: Instant?

    var sharing: TraktSharingImpl

}
