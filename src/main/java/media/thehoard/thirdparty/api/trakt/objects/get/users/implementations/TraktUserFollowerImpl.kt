package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserFollower

import java.time.Instant

data class TraktUserFollowerImpl(
        @SerializedName("followed_at") override var followedAt: Instant? = null,
        override var user: TraktUserImpl = TraktUserImpl()
) : TraktUserFollower
