package media.thehoard.thirdparty.api.trakt.objects.get.users.lists

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds

interface TraktListIds : TraktDefaultIds {
    var trakt: Int

    var slug: String

}
