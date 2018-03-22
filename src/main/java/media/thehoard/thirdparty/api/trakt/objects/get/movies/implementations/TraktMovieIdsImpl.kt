package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils

class TraktMovieIdsImpl : TraktMovieIds {
    override var trakt: Int = 0
    override var slug: String = ""
    override var imdb: String = ""
    override var tmdb: Int? = null

    override fun hasAnyId(): Boolean {
        return trakt > 0 || !slug.isEmpty() || !imdb.isEmpty() || (tmdb?.compareTo(0) ?: 0) > 0
    }

    override fun getBestId(): String {
        if (trakt > 0) return trakt.toString()

        if (!slug.isEmpty()) return slug

        if (!imdb.isEmpty()) return imdb

        return if (tmdb != null && tmdb!! > 0) tmdb!!.toString() else ""
    }
}
