package com.atherapp.thirdparty.api.trakt.core

import com.atherapp.thirdparty.api.trakt.extensions.validate
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IValidatable

interface TraktId {
    var trakt: Int
}

interface SlugId {
    var slug: String
}

interface TvdbId {
    var tvdb: Int
}

interface ImdbId {
    var imdb: String
}

interface TmdbId {
    var tmdb: Int
}

private interface TraktTmdbCompositeId : TraktId, TmdbId
private interface TraktSlugCompositeId : TraktId, SlugId
private interface TraktImdbTmdbCompositeId : TraktTmdbCompositeId, ImdbId
private interface TraktTvdbTmdbCompositeId : TraktTmdbCompositeId, TvdbId
private interface TraktSlugImdbTmdbCompositeId : TraktImdbTmdbCompositeId, TraktSlugCompositeId

sealed class TraktIds : IValidatable {
    val bestId: String
        get() = when (this) {
            is TraktId -> if (isValid(this.trakt)) this.trakt.toString() else ""
            is SlugId -> if (isValid(this.slug)) this.slug else ""
            is TvdbId -> if (isValid(this.tvdb)) this.tvdb.toString() else ""
            is ImdbId -> if (isValid(this.imdb)) this.imdb else ""
            is TmdbId -> if (isValid(this.tmdb)) this.tmdb.toString() else ""
            else -> ""
        }

    val hasAnyId: Boolean
        get() = bestId.isNotBlank()

    private fun idMatches(v1: String, v2: String) = isValid(v1) && isValid(v2) && v1 == v2
    private fun idMatches(v1: Int, v2: Int) = isValid(v1) && isValid(v2) && v1 == v2

    fun hasIdMatch(ids: TraktIds): Boolean = this is TraktId && ids is TraktId && idMatches(trakt, ids.trakt) ||
            this is SlugId && ids is SlugId && idMatches(slug, ids.slug) ||
            this is TvdbId && ids is TvdbId && idMatches(tvdb, ids.tvdb) ||
            this is ImdbId && ids is ImdbId && idMatches(imdb, ids.imdb) ||
            this is TmdbId && ids is TmdbId && idMatches(tmdb, ids.tmdb)

    fun isValid(stringId: String?) = !stringId.isNullOrBlank()

    fun isValid(intId: Int?) = intId != null && intId > 0

    infix fun like(ids: TraktIds) = hasIdMatch(ids)

    override fun validate(variableName: String) = hasAnyId.validate(variableName)
}

data class TraktMovieIds(
        override var trakt: Int = 0,
        override var slug: String = "",
        override var imdb: String = "",
        override var tmdb: Int = 0
) : TraktIds(), TraktSlugImdbTmdbCompositeId

data class TraktShowIds(
        override var trakt: Int = 0,
        override var slug: String = "",
        override var tvdb: Int = 0,
        override var imdb: String = "",
        override var tmdb: Int = 0
) : TraktIds(), TraktSlugImdbTmdbCompositeId, TraktTvdbTmdbCompositeId

data class TraktSeasonIds(
        override var trakt: Int = 0,
        override var tvdb: Int = 0,
        override var tmdb: Int = 0
) : TraktIds(), TraktTvdbTmdbCompositeId

data class TraktEpisodeIds(
        override var trakt: Int = 0,
        override var tvdb: Int = 0,
        override var imdb: String = "",
        override var tmdb: Int = 0
) : TraktIds(), TraktTvdbTmdbCompositeId, TraktImdbTmdbCompositeId

data class TraktPersonIds(
        override var trakt: Int = 0,
        override var slug: String = "",
        override var imdb: String = "",
        override var tmdb: Int = 0
) : TraktIds(), TraktSlugImdbTmdbCompositeId

data class TraktListIds(
        override var trakt: Int = 0,
        override var slug: String = ""
) : TraktIds(), TraktSlugCompositeId

data class TraktUserIds(
        override var slug: String = ""
) : TraktIds(), SlugId