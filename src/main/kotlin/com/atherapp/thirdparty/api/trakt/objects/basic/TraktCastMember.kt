package com.atherapp.thirdparty.api.trakt.objects.basic

import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson

interface TraktCastMember {
    var character: String

    var person: TraktPerson
}
