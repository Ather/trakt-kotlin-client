package com.atherapp.thirdparty.api.trakt.objects.get.shows

interface TraktMostAnticipatedShow : TraktShow {
    var listCount: Int?

    var show: TraktShow
}
