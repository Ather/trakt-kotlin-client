package com.atherapp.thirdparty.api.trakt.objects.basic.implementations

import com.atherapp.thirdparty.api.trakt.core.TraktDefaultIds
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktIds

data class TraktIdsImpl(
        override var trakt: Int = 0,
        override var slug: String = "",
        override var tvdb: Int? = null,
        override var imdb: String = "",
        override var tmdb: Int? = null
) : TraktIds {
    override fun hasIdMatch(ids: TraktDefaultIds): Boolean {
        return if (ids is TraktIdsImpl) {
            val (trakt1, slug1, tvdb1, imdb1, tmdb1) = ids
            return ((isValid(trakt) && isValid(trakt1) && trakt == trakt1) ||
                    (isValid(slug) && isValid(slug1) && slug == slug1) ||
                    (isValid(tvdb) && isValid(tvdb1) && tvdb == tvdb1) ||
                    (isValid(imdb) && isValid(imdb1) && imdb == imdb1) ||
                    (isValid(tmdb) && isValid(tmdb1) && tmdb == tmdb1))
        } else
            false
    }

    override fun hasAnyId(): Boolean {
        return getBestId().isNotBlank()
    }

    override fun getBestId(): String {
        return when {
            isValid(trakt) -> trakt.toString()
            isValid(slug) -> slug
            isValid(tvdb) -> tvdb.toString()
            isValid(imdb) -> imdb
            isValid(tmdb) -> tmdb.toString()
            else -> ""
        }
    }
}
