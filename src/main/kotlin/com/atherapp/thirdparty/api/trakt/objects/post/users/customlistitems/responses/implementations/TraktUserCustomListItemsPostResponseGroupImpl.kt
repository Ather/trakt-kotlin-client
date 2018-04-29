package com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponseGroup

data class TraktUserCustomListItemsPostResponseGroupImpl(
        override var movies: Int? = null,
        override var shows: Int? = null,
        override var seasons: Int? = null,
        override var episodes: Int? = null,
        override var people: Int? = null
) : TraktUserCustomListItemsPostResponseGroup
