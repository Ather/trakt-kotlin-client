package com.atherapp.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.enums.TraktUserLikeType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktComment
import com.atherapp.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUserLikeItem
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
import java.time.ZonedDateTime

data class TraktUserLikeItemImpl(
        @SerializedName("liked_at") override var likedAt: ZonedDateTime? = null,
        override var type: TraktUserLikeType = TraktUserLikeType.UNSPECIFIED,
        override var comment: TraktComment? = TraktCommentImpl(),
        override var list: TraktList? = TraktListImpl()
) : TraktUserLikeItem
