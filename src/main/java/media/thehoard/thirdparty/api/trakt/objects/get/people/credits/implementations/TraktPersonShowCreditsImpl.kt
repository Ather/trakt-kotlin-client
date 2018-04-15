package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCredits
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCastItem
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCrew

data class TraktPersonShowCreditsImpl(
        override var cast: List<TraktPersonShowCreditsCastItem> = listOf(),
        override var crew: TraktPersonShowCreditsCrew = TraktPersonShowCreditsCrewImpl()
) : TraktPersonShowCredits
