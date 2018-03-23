package media.thehoard.thirdparty.api.trakt.objects.basic

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl
import java.time.Instant

interface TraktComment {
    var id: Int

    var parentId: Int?

    var createdAt: Instant

    var updatedAt: Instant?

    var comment: String

    var isSpoiler: Boolean

    var isReview: Boolean

    var replies: Int?

    var likes: Int?

    var userRating: Float?

    var user: TraktUserImpl
}
