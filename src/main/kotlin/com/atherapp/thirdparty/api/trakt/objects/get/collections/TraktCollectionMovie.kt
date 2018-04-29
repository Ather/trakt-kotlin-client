package com.atherapp.thirdparty.api.trakt.objects.get.collections

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktMetadata
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import java.time.ZonedDateTime

interface TraktCollectionMovie : TraktMovie {
    var collectedAt: ZonedDateTime?

    var movie: TraktMovie

    var metadata: TraktMetadata?
}