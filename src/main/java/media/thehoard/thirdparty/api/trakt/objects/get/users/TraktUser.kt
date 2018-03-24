package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserIdsImpl

interface TraktUser {
    var username: String

    var private: Boolean?

    var name: String

    var vip: Boolean?

    var vipEp: Boolean?

    var ids: TraktUserIdsImpl

}
