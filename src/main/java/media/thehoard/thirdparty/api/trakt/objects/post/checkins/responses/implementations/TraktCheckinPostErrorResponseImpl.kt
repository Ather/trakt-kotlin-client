package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktCheckinPostErrorResponse

import java.time.Instant

data class TraktCheckinPostErrorResponseImpl(
        @SerializedName("expires_at") override var expiresAt: Instant? = null
) : TraktCheckinPostErrorResponse
