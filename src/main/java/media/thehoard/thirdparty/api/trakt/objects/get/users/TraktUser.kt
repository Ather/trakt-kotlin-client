package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImagesImpl
import java.time.ZonedDateTime

interface TraktUser {
    var username: String

    var private: Boolean?

    var name: String

    var vip: Boolean?

    var vipEp: Boolean?

    var ids: TraktUserIdsImpl

    var joinedAt: ZonedDateTime?

    var location: String

    var about: String

    var gender: String

    var age: Int?

    var images: TraktUserImagesImpl

    var vipOg: Boolean?

    var vipYears: Int?

}
