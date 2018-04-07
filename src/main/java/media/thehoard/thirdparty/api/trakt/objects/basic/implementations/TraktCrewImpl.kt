package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktCrew

data class TraktCrewImpl(
        override var production: List<TraktCrewMemberImpl> = listOf(),
        override var art: List<TraktCrewMemberImpl> = listOf(),
        override var crew: List<TraktCrewMemberImpl> = listOf(),
        @SerializedName("costume & make-up")
        override var costumeAndMakeup: List<TraktCrewMemberImpl> = listOf(),
        override var directing: List<TraktCrewMemberImpl> = listOf(),
        override var writing: List<TraktCrewMemberImpl> = listOf(),
        override var sound: List<TraktCrewMemberImpl> = listOf(),
        override var camera: List<TraktCrewMemberImpl> = listOf(),
        override var lighting: List<TraktCrewMemberImpl> = listOf(),
        @SerializedName("visual effects")
        override var visualEffects: List<TraktCrewMemberImpl> = listOf(),
        override var editing: List<TraktCrewMemberImpl> = listOf()
) : TraktCrew
