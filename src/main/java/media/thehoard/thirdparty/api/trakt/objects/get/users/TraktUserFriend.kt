package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl
import java.time.ZonedDateTime

interface TraktUserFriend {
    var friendsAt: ZonedDateTime?

    var user: TraktUserImpl

}
