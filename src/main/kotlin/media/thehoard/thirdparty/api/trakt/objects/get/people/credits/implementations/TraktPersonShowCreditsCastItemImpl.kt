package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonShowCreditsCastItem
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

data class TraktPersonShowCreditsCastItemImpl(
        override var character: String = "",
        override var show: TraktShow = TraktShowImpl()
) : TraktPersonShowCreditsCastItem
