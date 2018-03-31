package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsPostResponseGroupImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsPostResponseNotFoundGroupImpl

interface TraktUserCustomListItemsRemovePostResponse {
    var deleted: TraktUserCustomListItemsPostResponseGroupImpl
    var notFound: TraktUserCustomListItemsPostResponseNotFoundGroupImpl
}