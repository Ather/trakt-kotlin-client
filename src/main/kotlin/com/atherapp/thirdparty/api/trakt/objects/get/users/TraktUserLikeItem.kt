package com.atherapp.thirdparty.api.trakt.objects.get.users

import com.atherapp.thirdparty.api.trakt.enums.TraktUserLikeType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktComment
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import java.time.ZonedDateTime

interface TraktUserLikeItem {
    var likedAt: ZonedDateTime?

    var type: TraktUserLikeType

    var comment: TraktComment?

    var list: TraktList?

}
