package com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses

interface TraktUserCustomListItemsRemovePostResponse {
    var deleted: TraktUserCustomListItemsPostResponseGroup
    var notFound: TraktUserCustomListItemsPostResponseNotFoundGroup
}