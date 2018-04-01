package media.thehoard.thirdparty.api.trakt.objects.get.people.implementations

import media.thehoard.thirdparty.api.trakt.extensions.yearsBetween
import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPersonExtendedFull
import java.time.Instant

data class TraktPersonExtendedFullImpl(
        override var name: String = "",
        override var ids: TraktPersonIdsImpl = TraktPersonIdsImpl(),
        override var biography: String = "",
        override var birthday: Instant? = null,
        override var death: Instant? = null,
        override var birthplace: String = "",
        override var homepage: String = ""
) : TraktPersonExtendedFull {

    override val age: Int = birthday?.yearsBetween(death ?: Instant.now()) ?: 0
}
