package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils

data class TraktEpisodeIdsImpl(override var trakt: Int = 0,
                          override var tvdb: Int? = null,
                          override var imdb: String = "",
                          override var tmdb: Int? = null) : TraktEpisodeIds {
    override fun hasAnyId(): Boolean {
        return trakt > 0 || (if (tvdb != null) tvdb!!.compareTo(0) else 0) > 0 || !TraktUtils.isNullOrEmpty(imdb) || (if (tmdb != null) tmdb!!.compareTo(0) else 0) > 0
    }

    override fun getBestId(): String {
        if (trakt > 0) return trakt.toString()

        if (tvdb != null && tvdb!!.compareTo(0) > 0) return tvdb!!.toString()

        if (!TraktUtils.isNullOrEmpty(imdb)) return imdb

        return if (tmdb != null && tmdb!!.compareTo(0) > 0) tmdb!!.toString() else ""
    }
}
