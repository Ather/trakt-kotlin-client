package com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktMovieIds
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostMovie

data class TraktUserCustomListItemsPostMovieImpl(
        override var ids: TraktMovieIds = TraktMovieIds()
) : TraktUserCustomListItemsPostMovie
