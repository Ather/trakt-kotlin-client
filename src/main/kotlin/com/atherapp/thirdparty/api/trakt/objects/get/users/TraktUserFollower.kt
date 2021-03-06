package com.atherapp.thirdparty.api.trakt.objects.get.users

import java.time.ZonedDateTime

interface TraktUserFollower {
    var followedAt: ZonedDateTime?

    var user: TraktUser

}
