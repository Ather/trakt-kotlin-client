package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktUserLikeType
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktComment
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserLikeItem
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
import java.time.ZonedDateTime

data class TraktUserLikeItemImpl(
        @SerializedName("liked_at") override var likedAt: ZonedDateTime? = null,
        override var type: TraktUserLikeType = TraktUserLikeType.UNSPECIFIED,
        override var comment: TraktComment? = TraktCommentImpl(),
        override var list: TraktList? = TraktListImpl()
) : TraktUserLikeItem
