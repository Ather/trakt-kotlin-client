package com.atherapp.thirdparty.api.trakt.objects.post.users.responses.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUser
import com.atherapp.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl
import com.atherapp.thirdparty.api.trakt.objects.post.users.responses.TraktUserFollowUserPostResponse
import java.time.ZonedDateTime

data class TraktUserFollowUserPostResponseImpl(
        @SerializedName("approved_at")
        override var approvedAt: ZonedDateTime? = null,
        override var user: TraktUser = TraktUserImpl()
) : TraktUserFollowUserPostResponse
