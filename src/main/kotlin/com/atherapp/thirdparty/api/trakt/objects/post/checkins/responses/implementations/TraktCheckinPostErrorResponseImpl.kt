package com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.post.checkins.responses.TraktCheckinPostErrorResponse
import java.time.ZonedDateTime

data class TraktCheckinPostErrorResponseImpl(
        @SerializedName("expires_at") override var expiresAt: ZonedDateTime? = null
) : TraktCheckinPostErrorResponse
