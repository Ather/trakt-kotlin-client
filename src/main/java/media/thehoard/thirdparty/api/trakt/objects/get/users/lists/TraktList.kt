package media.thehoard.thirdparty.api.trakt.objects.get.users.lists

import media.thehoard.thirdparty.api.trakt.enums.TraktAccessScope
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortBy
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortHow
import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListIdsImpl

import java.time.Instant

interface TraktList {
    var name: String

    var description: String

    var privacy: TraktAccessScope

    var displayNumbers: Boolean?

    var allowComments: Boolean?

    var sortBy: TraktListSortBy

    var sortHow: TraktListSortHow

    var createdAt: Instant?

    var updatedAt: Instant?

    var itemCount: Int?

    var commentCount: Int?

    var likes: Int?

    var ids: TraktListIdsImpl

    var user: TraktUserImpl

}