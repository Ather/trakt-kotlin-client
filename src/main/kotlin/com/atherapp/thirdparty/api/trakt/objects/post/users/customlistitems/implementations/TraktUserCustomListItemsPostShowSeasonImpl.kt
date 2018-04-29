package com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShowEpisode
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShowSeason

data class TraktUserCustomListItemsPostShowSeasonImpl(
        override var number: Int = 0,
        override var episodes: MutableList<TraktUserCustomListItemsPostShowEpisode> = mutableListOf()
) : TraktUserCustomListItemsPostShowSeason
