package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl

import java.time.Instant

interface TraktUserFollowRequest {
    var id: Int

    var requestedAt: Instant?

    var user: TraktUserImpl

}
