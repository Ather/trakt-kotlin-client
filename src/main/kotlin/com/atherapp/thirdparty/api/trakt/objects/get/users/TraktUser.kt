package com.atherapp.thirdparty.api.trakt.objects.get.users

import com.atherapp.thirdparty.api.trakt.core.TraktUserIds
import java.time.ZonedDateTime

interface TraktUser {
    var username: String

    var private: Boolean

    var name: String?

    var vip: Boolean?

    var vipEp: Boolean?

    var ids: TraktUserIds

    var joinedAt: ZonedDateTime?

    var location: String?

    var about: String?

    var gender: String?

    var age: Int?

    var images: TraktUserImages?

    var vipOg: Boolean?

    var vipYears: Int?

}
