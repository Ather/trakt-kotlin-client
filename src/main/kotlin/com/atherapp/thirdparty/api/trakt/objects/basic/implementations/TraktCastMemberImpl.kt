package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktCastMember
import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson
import com.atherapp.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl

data class TraktCastMemberImpl(
        override var character: String = "",
        override var person: TraktPerson = TraktPersonImpl()
) : TraktCastMember
