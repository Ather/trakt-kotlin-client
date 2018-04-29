package com.atherapp.thirdparty.api.trakt.objects.basic

import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson

interface TraktCrewMember {
    var job: String

    var person: TraktPerson
}
