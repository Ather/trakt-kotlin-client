package media.thehoard.thirdparty.api.trakt.objects.get.people

import java.time.ZonedDateTime

interface TraktPerson {
    var name: String

    var ids: TraktPersonIds

    var biography: String?

    var birthday: ZonedDateTime?

    var death: ZonedDateTime?

    var birthplace: String?

    var homepage: String?

    val age: Int?
}
