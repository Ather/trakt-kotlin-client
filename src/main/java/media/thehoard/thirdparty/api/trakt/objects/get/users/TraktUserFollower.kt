package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl
import java.time.ZonedDateTime

interface TraktUserFollower {
    var followedAt: ZonedDateTime?

    var user: TraktUserImpl

}
