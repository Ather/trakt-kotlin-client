package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCrew
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCrewItem

data class TraktPersonShowCreditsCrewImpl(
        override var production: List<TraktPersonShowCreditsCrewItem> = listOf(),
        override var art: List<TraktPersonShowCreditsCrewItem> = listOf(),
        override var crew: List<TraktPersonShowCreditsCrewItem> = listOf(),
        @SerializedName("costume & make-up")
        override var costumeAndMakeup: List<TraktPersonShowCreditsCrewItem> = listOf(),
        override var directing: List<TraktPersonShowCreditsCrewItem> = listOf(),
        override var writing: List<TraktPersonShowCreditsCrewItem> = listOf(),
        override var sound: List<TraktPersonShowCreditsCrewItem> = listOf(),
        override var camera: List<TraktPersonShowCreditsCrewItem> = listOf(),
        override var lighting: List<TraktPersonShowCreditsCrewItem> = listOf(),
        @SerializedName("visual effects")
        override var visualEffects: List<TraktPersonShowCreditsCrewItem> = listOf(),
        override var editing: List<TraktPersonShowCreditsCrewItem> = listOf()
) : TraktPersonShowCreditsCrew
