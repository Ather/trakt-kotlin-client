package com.atherapp.thirdparty.api.trakt.objects.basic

import com.atherapp.thirdparty.api.trakt.objects.get.users.TraktUser
import java.time.ZonedDateTime

interface TraktComment {
    var id: Int

    var parentId: Int?

    var createdAt: ZonedDateTime

    var updatedAt: ZonedDateTime?

    var comment: String

    var isSpoiler: Boolean

    var isReview: Boolean

    var replies: Int?

    var likes: Int?

    var userRating: Float?

    var user: TraktUser
}
