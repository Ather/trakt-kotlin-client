package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktCrewMember
import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson
import com.atherapp.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl

data class TraktCrewMemberImpl(
        override var job: String = "",
        override var person: TraktPerson = TraktPersonImpl()
) : TraktCrewMember
