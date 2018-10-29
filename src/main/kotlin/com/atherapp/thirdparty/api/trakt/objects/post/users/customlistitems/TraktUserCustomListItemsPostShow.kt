package com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems

import com.atherapp.thirdparty.api.trakt.core.TraktShowIds

interface TraktUserCustomListItemsPostShow {
    var ids: TraktShowIds
    var seasons: MutableList<TraktUserCustomListItemsPostShowSeason>
}