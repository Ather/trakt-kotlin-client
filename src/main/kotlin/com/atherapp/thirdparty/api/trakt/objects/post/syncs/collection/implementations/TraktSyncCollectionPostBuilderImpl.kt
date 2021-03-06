package com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktMetadata
import com.atherapp.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.post.PostSeasons
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostShowEpisode
import com.atherapp.thirdparty.api.trakt.objects.post.syncs.collection.TraktSyncCollectionPostShowSeason
import java.time.ZonedDateTime
import java.util.*

class TraktSyncCollectionPostBuilderImpl {
    private val collectionPost: TraktSyncCollectionPostImpl = TraktSyncCollectionPostImpl()

    fun addMovie(movie: TraktMovie, metadata: TraktMetadataImpl? = null, collectedAt: ZonedDateTime? = null): TraktSyncCollectionPostBuilderImpl {
        movie.validate()
        return addMovieOrIgnore(movie, metadata, collectedAt)
    }

    fun addMovies(movies: Collection<TraktMovie>): TraktSyncCollectionPostBuilderImpl {
        for (movie in movies)
            addMovie(movie)

        return this
    }

    fun addShow(show: TraktShow, metadata: TraktMetadataImpl? = null, collectedAt: ZonedDateTime? = null, seasons: PostSeasons? = null): TraktSyncCollectionPostBuilderImpl {
        show.validate()
        if (seasons != null)
            createOrSetShow(show, createShowSeasons(seasons), metadata, collectedAt)
        else
            return addShowOrIgnore(show, metadata, collectedAt)

        return this
    }

    fun addShow(show: TraktShow, metadata: TraktMetadata? = null, collectedAt: ZonedDateTime? = null, vararg seasons: Int): TraktSyncCollectionPostBuilderImpl {
        show.validate()
        val showSeasons = createShowSeasons(*seasons)
        createOrSetShow(show, showSeasons, metadata, collectedAt)

        return this
    }

    fun addShows(shows: Collection<TraktShow>): TraktSyncCollectionPostBuilderImpl {
        if (shows.isEmpty()) return this

        for (show in shows)
            addShow(show)

        return this
    }

    fun addEpisodes(episodes: Collection<TraktEpisode>): TraktSyncCollectionPostBuilderImpl {
        if (episodes.isEmpty()) return this

        for (episode in episodes)
            addEpisode(episode)

        return this
    }

    fun addEpisode(episode: TraktEpisode, metadata: TraktMetadataImpl? = null, collectedAt: ZonedDateTime? = null): TraktSyncCollectionPostBuilderImpl {
        episode.validate()
        return addEpisodeOrIgnore(episode, metadata, collectedAt)
    }

    fun reset() {
        collectionPost.movies.clear()

        collectionPost.shows.clear()

        collectionPost.episodes.clear()
    }

    fun build(): TraktSyncCollectionPostImpl {
        return collectionPost
    }

    private fun containsMovie(movie: TraktMovie): Boolean {
        for (m in collectionPost.movies)
            if (m.ids like movie.ids) return true

        return false
    }

    private fun containsShow(show: TraktShow): Boolean {
        for (s in collectionPost.shows)
            if (s.ids like show.ids) return true

        return false
    }

    private fun containsEpisode(episode: TraktEpisode): Boolean {
        for (collectionEpisode in collectionPost.episodes)
            if (collectionEpisode.ids like episode.ids) return true

        return false
    }

    private fun addMovieOrIgnore(movie: TraktMovie, metadata: TraktMetadata? = null, collectedAt: ZonedDateTime? = null): TraktSyncCollectionPostBuilderImpl {
        if (containsMovie(movie)) return this

        val collectionMovie = TraktSyncCollectionPostMovieImpl()
        collectionMovie.ids = movie.ids
        collectionMovie.title = movie.title
        collectionMovie.year = movie.year

        if (metadata != null) collectionMovie.metadata = metadata

        if (collectedAt != null) collectionMovie.collectedAt = collectedAt

        collectionPost.movies.add(collectionMovie)

        return this
    }

    private fun addShowOrIgnore(show: TraktShow, metadata: TraktMetadata? = null, collectedAt: ZonedDateTime? = null): TraktSyncCollectionPostBuilderImpl {
        if (containsShow(show)) return this

        val collectionShow = TraktSyncCollectionPostShowImpl()
        collectionShow.ids = show.ids
        collectionShow.title = show.title
        collectionShow.year = show.year

        if (metadata != null) collectionShow.metadata = metadata

        if (collectedAt != null) collectionShow.collectedAt = collectedAt

        collectionPost.shows.add(collectionShow)

        return this
    }

    private fun addEpisodeOrIgnore(episode: TraktEpisode, metadata: TraktMetadataImpl? = null, collectedAt: ZonedDateTime? = null): TraktSyncCollectionPostBuilderImpl {
        if (containsEpisode(episode)) return this

        val collectionEpisode = TraktSyncCollectionPostEpisodeImpl()
        collectionEpisode.ids = episode.ids

        if (metadata != null) collectionEpisode.metadata = metadata

        if (collectedAt != null) collectionEpisode.collectedAt = collectedAt

        collectionPost.episodes.add(collectionEpisode)

        return this
    }

    private fun createOrSetShow(show: TraktShow, showSeasons: MutableList<TraktSyncCollectionPostShowSeason>, metadata: TraktMetadata? = null, collectedAt: ZonedDateTime? = null) {
        val existingShow = collectionPost.shows.firstOrNull { s -> s.ids like show.ids }

        if (existingShow != null)
            existingShow.seasons = showSeasons
        else {
            val collectionShow = TraktSyncCollectionPostShowImpl()
            collectionShow.ids = show.ids
            collectionShow.title = show.title
            collectionShow.year = show.year

            if (metadata != null) collectionShow.metadata = metadata

            if (collectedAt != null) collectionShow.collectedAt = collectedAt

            collectionShow.seasons = showSeasons

            collectionPost.shows.add(collectionShow)
        }
    }

    private fun createShowSeasons(vararg seasons: Int): MutableList<TraktSyncCollectionPostShowSeason> {
        val showSeasons = ArrayList<TraktSyncCollectionPostShowSeason>()

        for (season in seasons) {
            if (season < 0) throw IllegalArgumentException("at least one season number not valid")

            showSeasons.add(TraktSyncCollectionPostShowSeasonImpl(season))
        }

        return showSeasons
    }

    private fun createShowSeasons(seasons: PostSeasons): MutableList<TraktSyncCollectionPostShowSeason> {
        val showSeasons = ArrayList<TraktSyncCollectionPostShowSeason>()

        for (season in seasons) {
            if (season.number < 0) throw IllegalArgumentException("at least one season number not valid")

            val showSingleSeason = TraktSyncCollectionPostShowSeasonImpl(season.number)

            if (season.episodes.size > 0) {
                val showEpisodes = ArrayList<TraktSyncCollectionPostShowEpisode>()

                for (episode in season.episodes) {
                    if (episode < 0) throw IllegalArgumentException("at least one episode nubmer not valid")

                    showEpisodes.add(TraktSyncCollectionPostShowEpisodeImpl(episode))
                }

                showSingleSeason.episodes = showEpisodes
            }

            showSeasons.add(showSingleSeason)
        }

        return showSeasons
    }
}