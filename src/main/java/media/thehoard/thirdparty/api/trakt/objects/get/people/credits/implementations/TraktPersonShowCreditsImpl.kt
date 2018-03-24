package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCredits

data class TraktPersonShowCreditsImpl(
        override var cast: List<TraktPersonShowCreditsCastItemImpl> = listOf(),
        override var crew: TraktPersonShowCreditsCrewImpl = TraktPersonShowCreditsCrewImpl()
) : TraktPersonShowCredits
