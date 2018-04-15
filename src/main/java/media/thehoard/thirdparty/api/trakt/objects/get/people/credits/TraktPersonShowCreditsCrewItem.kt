package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktPersonShowCreditsCrewItem {
    var job: String

    var show: TraktShow

}
