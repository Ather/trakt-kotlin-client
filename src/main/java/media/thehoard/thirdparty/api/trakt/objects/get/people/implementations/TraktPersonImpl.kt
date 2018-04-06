package media.thehoard.thirdparty.api.trakt.objects.get.people.implementations

import media.thehoard.thirdparty.api.trakt.extensions.yearsBetween
import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPerson
import java.time.ZonedDateTime

data class TraktPersonImpl(
        override var name: String = "",
        override var ids: TraktPersonIdsImpl = TraktPersonIdsImpl(),
        override var biography: String = "",
        override var birthday: ZonedDateTime? = null,
        override var death: ZonedDateTime? = null,
        override var birthplace: String = "",
        override var homepage: String = ""
) : TraktPerson {
    override val age: Int = birthday?.yearsBetween(death ?: ZonedDateTime.now()) ?: 0
}
