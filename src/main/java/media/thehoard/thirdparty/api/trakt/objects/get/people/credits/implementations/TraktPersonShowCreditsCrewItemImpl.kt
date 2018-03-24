package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCrewItem
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

data class TraktPersonShowCreditsCrewItemImpl(
        override var job: String = "",
        override var show: TraktShowImpl = TraktShowImpl()
) : TraktPersonShowCreditsCrewItem
