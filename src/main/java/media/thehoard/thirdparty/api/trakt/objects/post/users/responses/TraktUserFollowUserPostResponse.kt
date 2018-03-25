package media.thehoard.thirdparty.api.trakt.objects.post.users.responses

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl
import java.time.Instant

interface TraktUserFollowUserPostResponse {
    var approvedAt: Instant?
    var user: TraktUserImpl
}