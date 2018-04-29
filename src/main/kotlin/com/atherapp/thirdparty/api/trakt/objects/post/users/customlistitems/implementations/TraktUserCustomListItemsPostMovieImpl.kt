package com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovieIds
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostMovie

data class TraktUserCustomListItemsPostMovieImpl(
        override var ids: TraktMovieIds = TraktMovieIdsImpl()
) : TraktUserCustomListItemsPostMovie
