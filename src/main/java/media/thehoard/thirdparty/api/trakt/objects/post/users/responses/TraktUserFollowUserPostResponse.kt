package media.thehoard.thirdparty.api.trakt.objects.post.users.responses

import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser
import java.time.ZonedDateTime

interface TraktUserFollowUserPostResponse {
    var approvedAt: ZonedDateTime?
    var user: TraktUser
}