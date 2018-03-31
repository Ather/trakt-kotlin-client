package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsRemovePostResponse

data class TraktUserCustomListItemsRemovePostResponseImpl(
        override var deleted: TraktUserCustomListItemsPostResponseGroupImpl = TraktUserCustomListItemsPostResponseGroupImpl(),
        @SerializedName("not_found")
        override var notFound: TraktUserCustomListItemsPostResponseNotFoundGroupImpl = TraktUserCustomListItemsPostResponseNotFoundGroupImpl()
) : TraktUserCustomListItemsRemovePostResponse
