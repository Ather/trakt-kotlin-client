package media.thehoard.thirdparty.api.trakt.objects.get.people.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPersonIds
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils

data class TraktPersonIdsImpl(
        override var trakt: Int = 0,
        override var slug: String = "",
        override var imdb: String = "",
        override var tmdb: Int? = null
) : TraktPersonIds {

    override fun hasAnyId(): Boolean {
        return trakt > 0 || !TraktUtils.isNullOrEmpty(slug) || !TraktUtils.isNullOrEmpty(imdb) || (if (tmdb != null)
            tmdb!!
                    .compareTo(0)
        else
            0) > 0
    }

    override fun getBestId(): String {
        if (trakt > 0) return trakt.toString()

        if (!TraktUtils.isNullOrEmpty(slug)) return slug

        if (!TraktUtils.isNullOrEmpty(imdb)) return imdb

        return if (tmdb != null && tmdb!!.compareTo(0) > 0) tmdb!!.toString() else ""
    }
}
