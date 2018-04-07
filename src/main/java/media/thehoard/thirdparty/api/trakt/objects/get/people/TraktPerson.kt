package media.thehoard.thirdparty.api.trakt.objects.get.people

import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonIdsImpl
import java.time.ZonedDateTime

interface TraktPerson {
    var name: String

    var ids: TraktPersonIdsImpl

    var biography: String?

    var birthday: ZonedDateTime?

    var death: ZonedDateTime?

    var birthplace: String?

    var homepage: String?

    val age: Int?
}
