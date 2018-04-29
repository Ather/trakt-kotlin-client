package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktCastAndCrew
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktCastMember
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktCrew

data class TraktCastAndCrewImpl(
        override var cast: List<TraktCastMember> = listOf(),
        override var crew: TraktCrew = TraktCrewImpl()
) : TraktCastAndCrew
