package com.atherapp.thirdparty.api.trakt.objects.get.movies

interface TraktBoxOfficeMovie : TraktMovie {
    var revenue: Long?

    var movie: TraktMovie
}
