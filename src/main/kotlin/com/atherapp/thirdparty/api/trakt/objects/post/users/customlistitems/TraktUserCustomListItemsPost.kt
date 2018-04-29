package com.atherapp.thirdparty.api.trakt.objects.post.users.customlistitems

import com.atherapp.thirdparty.api.trakt.objects.get.people.TraktPerson
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktUserCustomListItemsPost : IRequestBody {
    var movies: MutableList<TraktUserCustomListItemsPostMovie>
    var shows: MutableList<TraktUserCustomListItemsPostShow>
    var people: MutableList<TraktPerson>
}