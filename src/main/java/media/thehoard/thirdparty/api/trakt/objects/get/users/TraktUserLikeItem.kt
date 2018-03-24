package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.enums.TraktUserLikeType
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
import java.time.Instant

interface TraktUserLikeItem {
    var likedAt: Instant?

    var type: TraktUserLikeType

    var comment: TraktCommentImpl

    var list: TraktListImpl

}
