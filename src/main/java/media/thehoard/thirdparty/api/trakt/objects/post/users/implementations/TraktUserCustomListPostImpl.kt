package media.thehoard.thirdparty.api.trakt.objects.post.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktAccessScope
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortBy
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortHow
import media.thehoard.thirdparty.api.trakt.objects.post.users.TraktUserCustomListPost

data class TraktUserCustomListPostImpl(
        override var name: String = "",
        override var description: String? = null,
        override var privacy: TraktAccessScope = TraktAccessScope.UNSPECIFIED,
        @SerializedName("display_numbers")
        override var displayNumbers: Boolean? = null,
        @SerializedName("allow_comments")
        override var allowComments: Boolean? = null,
        @SerializedName("sort_by")
        override var sortBy: TraktListSortBy? = null,
        @SerializedName("sort_how")
        override var sortHow: TraktListSortHow? = null
) : TraktUserCustomListPost