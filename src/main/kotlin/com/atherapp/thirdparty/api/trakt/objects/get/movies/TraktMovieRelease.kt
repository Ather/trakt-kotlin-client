package com.atherapp.thirdparty.api.trakt.objects.get.movies

import com.atherapp.thirdparty.api.trakt.enums.TraktReleaseType
import java.time.ZonedDateTime

interface TraktMovieRelease {
    var country: String

    var certification: String

    var releaseDate: ZonedDateTime?

    var releaseType: TraktReleaseType

    var note: String?

}
