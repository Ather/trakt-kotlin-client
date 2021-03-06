package com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import java.time.ZonedDateTime

interface TraktCheckinPostResponse {
    var id: Long

    var watchedAt: ZonedDateTime?

    var sharing: TraktSharing

}
