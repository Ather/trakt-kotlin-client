package com.atherapp.thirdparty.api.trakt.objects.get.users.lists

import com.atherapp.thirdparty.api.trakt.core.TraktListIds
import com.atherapp.thirdparty.api.trakt.enums.TraktAccessScope
import com.atherapp.thirdparty.api.trakt.enums.TraktListSortBy
import com.atherapp.thirdparty.api.trakt.enums.TraktListSortHow
import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUser
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IValidatable
import java.time.ZonedDateTime

interface TraktList : IValidatable {
    var name: String

    var description: String

    var privacy: TraktAccessScope

    var displayNumbers: Boolean?

    var allowComments: Boolean?

    var sortBy: TraktListSortBy

    var sortHow: TraktListSortHow

    var createdAt: ZonedDateTime?

    var updatedAt: ZonedDateTime?

    var itemCount: Int?

    var commentCount: Int?

    var likes: Int?

    var ids: TraktListIds

    var user: TraktUser

}
