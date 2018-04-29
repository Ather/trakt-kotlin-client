package com.atherapp.thirdparty.api.trakt.objects.post.users

import com.atherapp.thirdparty.api.trakt.enums.TraktAccessScope
import com.atherapp.thirdparty.api.trakt.enums.TraktListSortBy
import com.atherapp.thirdparty.api.trakt.enums.TraktListSortHow
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktUserCustomListPost : IRequestBody {
    var name: String
    var description: String?
    var privacy: TraktAccessScope?
    var displayNumbers: Boolean?
    var allowComments: Boolean?
    var sortBy: TraktListSortBy?
    var sortHow: TraktListSortHow?
}