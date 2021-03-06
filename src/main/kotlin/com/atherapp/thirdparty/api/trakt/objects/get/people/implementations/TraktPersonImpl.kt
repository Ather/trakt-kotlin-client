package com.atherapp.thirdparty.api.trakt.objects.get.people.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktPersonIds
import com.atherapp.thirdparty.api.trakt.extensions.yearsBetween
import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson
import java.time.ZonedDateTime

data class TraktPersonImpl(
        override var name: String = "",
        override var ids: TraktPersonIds = TraktPersonIds(),
        override var biography: String? = null,
        override var birthday: ZonedDateTime? = null,
        override var death: ZonedDateTime? = null,
        override var birthplace: String? = null,
        override var homepage: String? = null
) : TraktPerson {
    override val age: Int = birthday?.yearsBetween(death ?: ZonedDateTime.now()) ?: 0
}
