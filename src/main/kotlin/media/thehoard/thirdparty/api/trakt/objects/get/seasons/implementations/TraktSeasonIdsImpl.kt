package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonIds

data class TraktSeasonIdsImpl(
        override var trakt: Int = 0,
        override var tvdb: Int? = null,
        override var tmdb: Int? = null
) : TraktSeasonIds {

    override fun hasAnyId(): Boolean {
        return getBestId().isNotBlank()
    }

    override fun getBestId(): String {
        return when {
            isValid(trakt) -> trakt.toString()
            isValid(tvdb) -> tvdb.toString()
            isValid(tmdb) -> tmdb.toString()
            else -> ""
        }
    }

    override fun hasIdMatch(ids: TraktDefaultIds): Boolean {
        return if (ids is TraktSeasonIdsImpl) {
            val (trakt1, tvdb1, tmdb1) = ids
            return ((isValid(trakt) && isValid(trakt1) && trakt == trakt1) ||
                    (isValid(tvdb) && isValid(tvdb1) && tvdb == tvdb1) ||
                    (isValid(tmdb) && isValid(tmdb1) && tmdb == tmdb1))
        } else
            false
    }
}
