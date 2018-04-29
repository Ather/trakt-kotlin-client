package com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponse
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponseGroup
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponseNotFoundGroup

data class TraktUserCustomListItemsPostResponseImpl(
        override var added: TraktUserCustomListItemsPostResponseGroup = TraktUserCustomListItemsPostResponseGroupImpl(),
        override var existing: TraktUserCustomListItemsPostResponseGroup = TraktUserCustomListItemsPostResponseGroupImpl(),
        @SerializedName("not_found")
        override var notFound: TraktUserCustomListItemsPostResponseNotFoundGroup = TraktUserCustomListItemsPostResponseNotFoundGroupImpl()
) : TraktUserCustomListItemsPostResponse
