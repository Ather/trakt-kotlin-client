package media.thehoard.thirdparty.api.trakt.objects.get.people

import java.time.Instant

interface TraktPersonExtendedFull : TraktPerson {
    var biography: String

    var birthday: Instant?

    var death: Instant?

    var birthplace: String

    var homepage: String

    val age: Int
}
