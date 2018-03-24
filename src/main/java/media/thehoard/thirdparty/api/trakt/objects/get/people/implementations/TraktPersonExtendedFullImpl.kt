package media.thehoard.thirdparty.api.trakt.objects.get.people.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPersonExtendedFull

import java.time.Instant
import java.time.Period
import java.time.ZoneId

data class TraktPersonExtendedFullImpl(
        override var name: String = "",
        override var ids: TraktPersonIdsImpl = TraktPersonIdsImpl(),
        override var biography: String = "",
        override var birthday: Instant? = null,
        override var death: Instant? = null,
        override var birthplace: String = "",
        override var homepage: String = ""
) : TraktPersonExtendedFull {

    override val age: Int
        get() = if (birthday != null)
            if (death != null)
                Period
                        .between(birthday!!.atZone(ZoneId.systemDefault()).toLocalDate(), death!!
                                .atZone(ZoneId.systemDefault()).toLocalDate()).years
            else
                Period.between(birthday!!.atZone(ZoneId.systemDefault()).toLocalDate(), Instant.now()
                        .atZone(ZoneId.systemDefault()).toLocalDate()).years
        else
            0
}
