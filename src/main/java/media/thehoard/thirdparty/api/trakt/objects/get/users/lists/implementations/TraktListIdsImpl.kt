package media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktListIds
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils

data class TraktListIdsImpl(
        override var trakt: Int = 0,
        override var slug: String = ""
) : TraktListIds {

    override fun hasAnyId(): Boolean {
        return trakt > 0 || !TraktUtils.isNullOrEmpty(slug)
    }

    override fun getBestId(): String {
        if (trakt > 0) return trakt.toString()

        return if (!TraktUtils.isNullOrEmpty(slug)) slug else ""
    }
}
