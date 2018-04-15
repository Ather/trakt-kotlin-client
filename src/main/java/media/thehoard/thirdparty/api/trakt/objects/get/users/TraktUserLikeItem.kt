package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.enums.TraktUserLikeType
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktComment
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList
import java.time.ZonedDateTime

interface TraktUserLikeItem {
    var likedAt: ZonedDateTime?

    var type: TraktUserLikeType

    var comment: TraktComment?

    var list: TraktList?

}
