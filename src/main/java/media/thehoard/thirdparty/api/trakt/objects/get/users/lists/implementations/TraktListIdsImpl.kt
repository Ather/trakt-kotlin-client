package media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktListIds

data class TraktListIdsImpl(
        override var trakt: Int = 0,
        override var slug: String = ""
) : TraktListIds {

    override fun hasAnyId(): Boolean {
        return getBestId().isNotEmpty()
    }

    override fun getBestId(): String {
        return when {
            isValid(trakt) -> trakt.toString()
            isValid(slug) -> slug
            else -> ""
        }
    }

    override fun hasIdMatch(ids: TraktDefaultIds): Boolean {
        return if (ids is TraktListIdsImpl) {
            val (trakt1, slug1) = ids
            return ((isValid(trakt) && isValid(trakt1) && trakt == trakt1) ||
                    (isValid(slug) && isValid(slug1) && slug == slug1))
        } else
            false
    }
}
