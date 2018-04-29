package com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponseGroup
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponseNotFoundGroup
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsRemovePostResponse

data class TraktUserCustomListItemsRemovePostResponseImpl(
        override var deleted: TraktUserCustomListItemsPostResponseGroup = TraktUserCustomListItemsPostResponseGroupImpl(),
        @SerializedName("not_found")
        override var notFound: TraktUserCustomListItemsPostResponseNotFoundGroup = TraktUserCustomListItemsPostResponseNotFoundGroupImpl()
) : TraktUserCustomListItemsRemovePostResponse
