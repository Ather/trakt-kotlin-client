package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImagesImpl

import java.time.Instant

interface TraktUserExtendedFull : TraktUser {
    var joinedAt: Instant?

    var location: String

    var about: String

    var gender: String

    var age: Int?

    var images: TraktUserImagesImpl

}
