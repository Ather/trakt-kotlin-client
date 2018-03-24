package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonShowCreditsCastItemImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonShowCreditsCrewImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonShowCreditsImpl

interface TraktPersonShowCredits {
    var cast: List<TraktPersonShowCreditsCastItemImpl>

    var crew: TraktPersonShowCreditsCrewImpl

}
