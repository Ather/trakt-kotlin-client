package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl

import java.time.Instant

interface TraktUserFriend {
    var friendsAt: Instant?

    var user: TraktUserImpl

}
