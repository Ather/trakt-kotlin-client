package com.atherapp.thirdparty.api.trakt.objects.get.people.credits

import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktPersonShowCreditsCastItem {
    var character: String

    var show: TraktShow

}
