package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses

import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsPostResponseGroupImpl
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations.TraktUserCustomListItemsPostResponseNotFoundGroupImpl

interface TraktUserCustomListItemsPostResponse {
    var added: TraktUserCustomListItemsPostResponseGroupImpl
    var existing: TraktUserCustomListItemsPostResponseGroupImpl
    var notFound: TraktUserCustomListItemsPostResponseNotFoundGroupImpl
}