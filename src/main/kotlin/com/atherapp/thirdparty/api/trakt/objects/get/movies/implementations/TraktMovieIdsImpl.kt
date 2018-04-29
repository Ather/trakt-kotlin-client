package com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktDefaultIds
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovieIds

data class TraktMovieIdsImpl(
        override var trakt: Int = 0,
        override var slug: String = "",
        override var imdb: String = "",
        override var tmdb: Int? = null
) : TraktMovieIds {

    override fun hasAnyId(): Boolean {
        return getBestId().isNotBlank()
    }

    override fun getBestId(): String {
        return when {
            isValid(trakt) -> trakt.toString()
            isValid(slug) -> slug
            isValid(imdb) -> imdb
            isValid(tmdb) -> tmdb.toString()
            else -> ""
        }
    }

    override fun hasIdMatch(ids: TraktDefaultIds): Boolean {
        return if (ids is TraktMovieIdsImpl) {
            val (trakt1, slug1, imdb1, tmdb1) = ids
            return ((isValid(trakt) && isValid(trakt1) && trakt == trakt1) ||
                    (isValid(slug) && isValid(slug1) && slug == slug1) ||
                    (isValid(imdb) && isValid(imdb1) && imdb == imdb1) ||
                    (isValid(tmdb) && isValid(tmdb1) && tmdb == tmdb1))
        } else
            false
    }
}
