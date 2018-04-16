package media.thehoard.thirdparty.api.trakt.objects.get.users

import java.time.ZonedDateTime

interface TraktUserFriend {
    var friendsAt: ZonedDateTime?

    var user: TraktUser

}
