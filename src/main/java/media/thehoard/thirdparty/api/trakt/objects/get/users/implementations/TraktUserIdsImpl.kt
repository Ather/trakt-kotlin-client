package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserIds
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils

data class TraktUserIdsImpl(
        override var slug: String = ""
) : TraktUserIds {

    override fun hasAnyId(): Boolean {
        return !TraktUtils.isNullOrEmpty(slug)
    }

    override fun getBestId(): String {
        return if (!TraktUtils.isNullOrEmpty(slug)) slug else ""
    }
}
