package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses

interface TraktUserCustomListItemsPostResponse {
    var added: TraktUserCustomListItemsPostResponseGroup
    var existing: TraktUserCustomListItemsPostResponseGroup
    var notFound: TraktUserCustomListItemsPostResponseNotFoundGroup
}