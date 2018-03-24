package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonIds

data class TraktSeasonIdsImpl(override var trakt: Int = 0,
                              override var tvdb: Int? = null,
                              override var tmdb: Int? = null) : TraktSeasonIds {
    override fun hasAnyId(): Boolean {
        return trakt > 0 || (if (tvdb != null) tvdb!!.compareTo(0) else 0) > 0 || (if (tmdb != null)
            tmdb!!.compareTo(0)
        else
            0) > 0
    }

    override fun getBestId(): String {
        if (trakt > 0) return trakt.toString()

        if (tvdb != null && tvdb!! > 0) return tvdb!!.toString()

        return if (tmdb != null && tmdb!! > 0) tmdb!!.toString() else ""
    }
}
