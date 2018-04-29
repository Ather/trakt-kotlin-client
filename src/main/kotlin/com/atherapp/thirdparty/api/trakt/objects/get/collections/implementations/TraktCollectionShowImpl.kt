package com.atherapp.thirdparty.api.trakt.objects.get.collections.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionShow
import com.atherapp.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowSeason
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

data class TraktCollectionShowImpl(
        @SerializedName("last_collected_at")
        override var lastCollectedAt: ZonedDateTime? = null,
        override var show: TraktShow = TraktShowImpl(),
        override var seasons: MutableList<TraktCollectionShowSeason> = mutableListOf()
) : TraktCollectionShow, TraktShow by show
