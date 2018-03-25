package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserIds
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils

data class TraktUserIdsImpl(
        override var slug: String = ""
) : TraktUserIds {

    override fun hasAnyId(): Boolean {
        return getBestId().isNotEmpty()
    }

    override fun getBestId(): String {
        return when {
            isValid(slug) -> slug
            else -> ""
        }
    }

    override fun hasIdMatch(ids: TraktDefaultIds): Boolean {
        return if (ids is TraktUserIdsImpl) {
            val (slug1) = ids
            return (isValid(slug) && isValid(slug1) && slug == slug1)
        } else
            false
    }
}
