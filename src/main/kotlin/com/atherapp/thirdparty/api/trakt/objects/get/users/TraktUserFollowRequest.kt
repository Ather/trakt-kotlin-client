package com.atherapp.thirdparty.api.trakt.objects.get.users

import java.time.ZonedDateTime

interface TraktUserFollowRequest {
    var id: Int

    var requestedAt: ZonedDateTime?

    var user: TraktUser

}
