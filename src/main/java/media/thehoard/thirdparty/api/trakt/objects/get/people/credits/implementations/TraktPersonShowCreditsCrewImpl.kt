package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCrew

data class TraktPersonShowCreditsCrewImpl(
        override var production: List<TraktPersonShowCreditsCrewItemImpl> = listOf(),
        override var art: List<TraktPersonShowCreditsCrewItemImpl> = listOf(),
        override var crew: List<TraktPersonShowCreditsCrewItemImpl> = listOf(),
        @SerializedName("costume & make-up")
        override var costumeAndMakeup: List<TraktPersonShowCreditsCrewItemImpl> = listOf(),
        override var directing: List<TraktPersonShowCreditsCrewItemImpl> = listOf(),
        override var writing: List<TraktPersonShowCreditsCrewItemImpl> = listOf(),
        override var sound: List<TraktPersonShowCreditsCrewItemImpl> = listOf(),
        override var camera: List<TraktPersonShowCreditsCrewItemImpl> = listOf(),
        override var lighting: List<TraktPersonShowCreditsCrewItemImpl> = listOf(),
        @SerializedName("visual effects")
        override var visualEffects: List<TraktPersonShowCreditsCrewItemImpl> = listOf(),
        override var editing: List<TraktPersonShowCreditsCrewItemImpl> = listOf()
) : TraktPersonShowCreditsCrew
