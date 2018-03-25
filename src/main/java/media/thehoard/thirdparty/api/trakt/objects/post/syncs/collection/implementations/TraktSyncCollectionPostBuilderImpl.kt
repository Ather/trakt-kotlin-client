package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktMetadata
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.post.PostSeasons
import java.time.Instant
import java.util.*

class TraktSyncCollectionPostBuilderImpl {
    private val collectionPost: TraktSyncCollectionPostImpl = TraktSyncCollectionPostImpl()

    fun addMovie(movie: TraktMovie, metadata: TraktMetadataImpl? = null, collectedAt: Instant? = null): TraktSyncCollectionPostBuilderImpl {
        validateMovie(movie)

        return addMovieOrIgnore(movie, metadata, collectedAt)
    }

    fun addMovies(movies: Collection<TraktMovie>): TraktSyncCollectionPostBuilderImpl {
        for (movie in movies)
            addMovie(movie)

        return this
    }

    fun addShow(show: TraktShow, metadata: TraktMetadataImpl? = null, collectedAt: Instant? = null, seasons: PostSeasons? = null): TraktSyncCollectionPostBuilderImpl {
        validateShow(show)

        if (seasons != null)
            createOrSetShow(show, createShowSeasons(seasons), metadata, collectedAt)
        else
            return addShowOrIgnore(show, metadata, collectedAt)

        return this
    }

    fun addShow(show: TraktShow, metadata: TraktMetadataImpl? = null, collectedAt: Instant? = null, vararg seasons: Int): TraktSyncCollectionPostBuilderImpl {
        validateShow(show)

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

    fun addEpisode(episode: TraktEpisode, metadata: TraktMetadataImpl? = null, collectedAt: Instant? = null): TraktSyncCollectionPostBuilderImpl {
        validateEpisode(episode)

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

    private fun validateMovie(movie: TraktMovie) {
        if (!movie.ids.hasAnyId()) throw IllegalArgumentException("no movie ids set or valid")

        if (movie.year != null && movie.year!!.toString().length != 4)
            throw IllegalArgumentException("movie year not valid")
    }

    private fun validateShow(show: TraktShow) {
        if (!show.ids.hasAnyId()) throw IllegalArgumentException("no show ids set or valid")

        if (show.year != null && show.year!!.toString().length != 4)
            throw IllegalArgumentException("show year not valid")
    }

    private fun validateEpisode(episode: TraktEpisode) {
        if (!episode.ids.hasAnyId()) throw IllegalArgumentException("no episode ids set or valid")
    }

    //TODO Consider the equality test used in these methods.
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

    private fun addMovieOrIgnore(movie: TraktMovie, metadata: TraktMetadataImpl? = null, collectedAt: Instant? = null): TraktSyncCollectionPostBuilderImpl {
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

    private fun addShowOrIgnore(show: TraktShow, metadata: TraktMetadataImpl? = null, collectedAt: Instant? = null): TraktSyncCollectionPostBuilderImpl {
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

    private fun addEpisodeOrIgnore(episode: TraktEpisode, metadata: TraktMetadataImpl? = null, collectedAt: Instant? = null): TraktSyncCollectionPostBuilderImpl {
        if (containsEpisode(episode)) return this

        val collectionEpisode = TraktSyncCollectionPostEpisodeImpl()
        collectionEpisode.ids = episode.ids

        if (metadata != null) collectionEpisode.metadata = metadata

        if (collectedAt != null) collectionEpisode.collectedAt = collectedAt

        collectionPost.episodes.add(collectionEpisode)

        return this
    }

    //TODO Equality check
    private fun createOrSetShow(show: TraktShow, showSeasons: MutableList<TraktSyncCollectionPostShowSeasonImpl>, metadata: TraktMetadataImpl? = null, collectedAt: Instant? = null) {
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

    private fun createShowSeasons(vararg seasons: Int): MutableList<TraktSyncCollectionPostShowSeasonImpl> {
        val showSeasons = ArrayList<TraktSyncCollectionPostShowSeasonImpl>()

        for (season in seasons) {
            if (season < 0) throw IllegalArgumentException("at least one season number not valid")

            showSeasons.add(TraktSyncCollectionPostShowSeasonImpl(season))
        }

        return showSeasons
    }

    private fun createShowSeasons(seasons: PostSeasons): MutableList<TraktSyncCollectionPostShowSeasonImpl> {
        val showSeasons = ArrayList<TraktSyncCollectionPostShowSeasonImpl>()

        for (season in seasons) {
            if (season.number < 0) throw IllegalArgumentException("at least one season number not valid")

            val showSingleSeason = TraktSyncCollectionPostShowSeasonImpl(season.number)

            if (season.episodes.size > 0) {
                val showEpisodes = ArrayList<TraktSyncCollectionPostShowEpisodeImpl>()

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