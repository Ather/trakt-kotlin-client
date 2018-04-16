package media.thehoard.thirdparty.api.trakt.objects.get.people.implementations

import media.thehoard.thirdparty.api.trakt.extensions.yearsBetween
import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPerson
import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPersonIds
import java.time.ZonedDateTime

data class TraktPersonImpl(
        override var name: String = "",
        override var ids: TraktPersonIds = TraktPersonIdsImpl(),
        override var biography: String? = null,
        override var birthday: ZonedDateTime? = null,
        override var death: ZonedDateTime? = null,
        override var birthplace: String? = null,
        override var homepage: String? = null
) : TraktPerson {
    override val age: Int = birthday?.yearsBetween(death ?: ZonedDateTime.now()) ?: 0
}
