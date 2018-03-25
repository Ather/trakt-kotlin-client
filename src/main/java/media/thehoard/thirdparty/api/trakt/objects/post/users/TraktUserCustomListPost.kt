package media.thehoard.thirdparty.api.trakt.objects.post.users

import media.thehoard.thirdparty.api.trakt.enums.TraktAccessScope
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortBy
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortHow

interface TraktUserCustomListPost {
    var name: String
    var description: String?
    var privacy: TraktAccessScope
    var displayNumbers: Boolean?
    var allowComments: Boolean?
    var sortBy: TraktListSortBy?
    var sortHow: TraktListSortHow?
}