package com.atherapp.thirdparty.api.trakt.objects.get.people.credits

interface TraktPersonShowCredits {
    var cast: List<TraktPersonShowCreditsCastItem>

    var crew: TraktPersonShowCreditsCrew

}
