package com.atherapp.thirdparty.api.trakt.objects.get.people.credits

import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktPersonShowCreditsCrewItem {
    var job: String

    var show: TraktShow

}
