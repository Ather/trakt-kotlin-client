package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserFollowRequest

import java.time.Instant

data class TraktUserFollowRequestImpl(
        override var id: Int = 0,
        @SerializedName("requested_at") override var requestedAt: Instant? = null,
        override var user: TraktUserImpl = TraktUserImpl()
) : TraktUserFollowRequest
