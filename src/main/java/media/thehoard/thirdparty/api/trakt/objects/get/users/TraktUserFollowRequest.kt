package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl
import java.time.ZonedDateTime

interface TraktUserFollowRequest {
    var id: Int

    var requestedAt: ZonedDateTime?

    var user: TraktUserImpl

}
