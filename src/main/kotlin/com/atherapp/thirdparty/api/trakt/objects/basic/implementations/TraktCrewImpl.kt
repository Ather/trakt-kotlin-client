package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktCrew
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktCrewMember

data class TraktCrewImpl(
        override var production: List<TraktCrewMember> = listOf(),
        override var art: List<TraktCrewMember> = listOf(),
        override var crew: List<TraktCrewMember> = listOf(),
        @SerializedName("costume & make-up")
        override var costumeAndMakeup: List<TraktCrewMember> = listOf(),
        override var directing: List<TraktCrewMember> = listOf(),
        override var writing: List<TraktCrewMember> = listOf(),
        override var sound: List<TraktCrewMember> = listOf(),
        override var camera: List<TraktCrewMember> = listOf(),
        override var lighting: List<TraktCrewMember> = listOf(),
        @SerializedName("visual effects")
        override var visualEffects: List<TraktCrewMember> = listOf(),
        override var editing: List<TraktCrewMember> = listOf()
) : TraktCrew
