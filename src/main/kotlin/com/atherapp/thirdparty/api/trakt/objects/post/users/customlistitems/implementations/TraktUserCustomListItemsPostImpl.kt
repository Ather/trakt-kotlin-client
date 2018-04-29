package com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.implementations

import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPost
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostMovie
import com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems.TraktUserCustomListItemsPostShow
import com.atherapp.thirdparty.api.trakt.utils.Json

data class TraktUserCustomListItemsPostImpl(
        override var movies: MutableList<TraktUserCustomListItemsPostMovie> = mutableListOf(),
        override var shows: MutableList<TraktUserCustomListItemsPostShow> = mutableListOf(),
        override var people: MutableList<TraktPerson> = mutableListOf()
) : TraktUserCustomListItemsPost {
    override fun toJson(): String = Json.serialize(this)

    override fun validate(variableName: String) {}

    companion object {
        fun builder(): TraktUserCustomListItemsPostBuilder {
            return TraktUserCustomListItemsPostBuilder()
        }
    }
}

