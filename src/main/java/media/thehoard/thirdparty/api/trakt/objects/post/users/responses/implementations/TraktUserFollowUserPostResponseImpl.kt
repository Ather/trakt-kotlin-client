package media.thehoard.thirdparty.api.trakt.objects.post.users.responses.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.responses.TraktUserFollowUserPostResponse

import java.time.Instant

data class TraktUserFollowUserPostResponseImpl(
        @SerializedName("approved_at")
        override var approvedAt: Instant? = null,
        override var user: TraktUserImpl = TraktUserImpl()
) : TraktUserFollowUserPostResponse
