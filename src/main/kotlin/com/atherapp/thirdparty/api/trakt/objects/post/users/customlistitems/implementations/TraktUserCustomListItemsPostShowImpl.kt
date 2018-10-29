package com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktShowIds
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShow
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShowSeason

data class TraktUserCustomListItemsPostShowImpl(
        override var ids: TraktShowIds = TraktShowIds(),
        override var seasons: MutableList<TraktUserCustomListItemsPostShowSeason> = mutableListOf()
) : TraktUserCustomListItemsPostShow
