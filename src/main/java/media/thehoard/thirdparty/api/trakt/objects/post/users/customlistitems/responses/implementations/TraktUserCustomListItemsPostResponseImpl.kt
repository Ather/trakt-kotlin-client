package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponse

data class TraktUserCustomListItemsPostResponseImpl(
        override var added: TraktUserCustomListItemsPostResponseGroupImpl = TraktUserCustomListItemsPostResponseGroupImpl(),
        override var existing: TraktUserCustomListItemsPostResponseGroupImpl = TraktUserCustomListItemsPostResponseGroupImpl(),
        @SerializedName("not_found")
        override var notFound: TraktUserCustomListItemsPostResponseNotFoundGroupImpl = TraktUserCustomListItemsPostResponseNotFoundGroupImpl()
) : TraktUserCustomListItemsPostResponse
