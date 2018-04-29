package com.atherapp.thirdparty.api.trakt.objects.basic

interface TraktCastAndCrew {
    var cast: List<TraktCastMember>

    var crew: TraktCrew
}
