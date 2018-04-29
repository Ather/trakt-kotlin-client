package com.atherapp.thirdparty.api.trakt.objects.get.users.lists.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.enums.TraktAccessScope
import com.atherapp.thirdparty.api.trakt.enums.TraktListSortBy
import com.atherapp.thirdparty.api.trakt.enums.TraktListSortHow
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUser
import com.atherapp.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktListIds
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IValidatable
import java.time.ZonedDateTime

data class TraktListImpl(
        override var name: String = "",
        override var description: String = "",
        override var privacy: TraktAccessScope = TraktAccessScope.UNSPECIFIED,
        @SerializedName("display_numbers") override var displayNumbers: Boolean? = null,
        @SerializedName("allow_comments") override var allowComments: Boolean? = null,
        @SerializedName("sort_by") override var sortBy: TraktListSortBy = TraktListSortBy.UNSPECIFIED,
        @SerializedName("sort_how") override var sortHow: TraktListSortHow = TraktListSortHow.UNSPECIFIED,
        @SerializedName("created_at") override var createdAt: ZonedDateTime? = null,
        @SerializedName("updated_at") override var updatedAt: ZonedDateTime? = null,
        @SerializedName("item_count") override var itemCount: Int? = null,
        @SerializedName("comment_count") override var commentCount: Int? = null,
        override var likes: Int? = null,
        override var ids: TraktListIds = TraktListIdsImpl(),
        override var user: TraktUser = TraktUserImpl()
) : TraktList, IValidatable by ids
