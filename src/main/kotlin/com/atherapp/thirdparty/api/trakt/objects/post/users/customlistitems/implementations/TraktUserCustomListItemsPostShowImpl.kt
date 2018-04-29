package com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShowIds
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShow
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShowSeason

data class TraktUserCustomListItemsPostShowImpl(
        override var ids: TraktShowIds = TraktShowIdsImpl(),
        override var seasons: MutableList<TraktUserCustomListItemsPostShowSeason> = mutableListOf()
) : TraktUserCustomListItemsPostShow
