package com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktMostAnticipatedShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow

data class TraktMostAnticipatedShowImpl(
        @SerializedName("list_count")
        override var listCount: Int? = null,
        override var show: TraktShow = TraktShowImpl()
) : TraktMostAnticipatedShow, TraktShow by show
