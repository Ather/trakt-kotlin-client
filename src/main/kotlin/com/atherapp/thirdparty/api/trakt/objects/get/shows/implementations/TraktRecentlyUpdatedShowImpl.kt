package com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktRecentlyUpdatedShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

data class TraktRecentlyUpdatedShowImpl(
        @SerializedName("updated_at")
        override var recentlyUpdatedAt: ZonedDateTime? = null,
        override var show: TraktShow = TraktShowImpl()
) : TraktRecentlyUpdatedShow, TraktShow by show
