package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktIds

data class TraktIdsImpl(override var trakt: Int = 0,
                        override var slug: String = "",
                        override var tvdb: Int? = null,
                        override var imdb: String = "",
                        override var tmdb: Int? = null) : TraktIds {

    override fun hasAnyId(): Boolean {
        return trakt > 0 || (if (tvdb != null) tvdb!!.compareTo(0) else 0) > 0 || !slug.isEmpty() || !imdb.isEmpty()
                || (if (tmdb != null) tmdb!!.compareTo(0) else 0) > 0
    }

    override fun getBestId(): String {
        if (trakt > 0) return trakt.toString()

        if (!slug.isEmpty()) return slug

        if (tvdb != null && tvdb!! > 0) return tvdb!!.toString()

        if (!imdb.isEmpty()) return imdb

        return if (tmdb != null && tmdb!! > 0) tmdb!!.toString() else ""

    }
}
