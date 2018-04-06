package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserFriend
import java.time.ZonedDateTime

data class TraktUserFriendImpl(
        @SerializedName("friends_at") override var friendsAt: ZonedDateTime? = null,
        override var user: TraktUserImpl = TraktUserImpl()
) : TraktUserFriend
