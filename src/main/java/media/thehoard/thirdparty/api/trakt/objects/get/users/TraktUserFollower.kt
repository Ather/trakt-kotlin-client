package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl

import java.time.Instant

interface TraktUserFollower {
    var followedAt: Instant?

    var user: TraktUserImpl

}
