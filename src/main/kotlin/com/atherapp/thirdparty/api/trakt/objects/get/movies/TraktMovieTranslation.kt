package com.atherapp.thirdparty.api.trakt.objects.get.movies

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktTranslation

interface TraktMovieTranslation : TraktTranslation {
    var tagline: String?

}
