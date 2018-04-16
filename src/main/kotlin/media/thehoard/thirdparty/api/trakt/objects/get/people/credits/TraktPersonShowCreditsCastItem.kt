package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktPersonShowCreditsCastItem {
    var character: String

    var show: TraktShow

}
