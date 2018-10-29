package com.atherapp.thirdparty.api.trakt.objects.get.people

import com.atherapp.thirdparty.api.trakt.core.TraktPersonIds
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
