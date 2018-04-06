package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.post.PostRatingsSeasons
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.AbstractTraktSyncPostBuilder
import java.time.ZonedDateTime
import java.util.*

class TraktSyncRatingsPostBuilder : AbstractTraktSyncPostBuilder<TraktSyncRatingsPostImpl, TraktSyncRatingsPostBuilder>() {
    private val ratingsPost: TraktSyncRatingsPostImpl = TraktSyncRatingsPostImpl()

    fun addMovies(movies: Collection<TraktMovie>): TraktSyncRatingsPostBuilder {
        if (movies.isEmpty()) return this

        for (movie in movies)
            addMovie(movie)

        return this
    }

    fun addMovie(movie: TraktMovie, rating: Int? = null, ratedAt: ZonedDateTime? = null): TraktSyncRatingsPostBuilder {
        validateMovie(movie)
        if (rating != null)
            validateRating(rating)

        return addMovieOrIgnore(movie, rating, ratedAt)
    }

    fun addShows(shows: Collection<TraktShow>): TraktSyncRatingsPostBuilder {
        if (shows.isEmpty()) return this

        for (show in shows)
            addShow(show)

        return this
    }

    fun addShow(show: TraktShow, rating: Int? = null, ratedAt: ZonedDateTime? = null, vararg seasons: Int): TraktSyncRatingsPostBuilder {
        validateShow(show)
        if (rating != null)
            validateRating(rating)

        if (seasons.isNotEmpty())
            createOrSetShow(show, createShowSeasons(*seasons), rating, ratedAt)
        else
            addShowOrIgnore(show, rating, ratedAt)

        return this
    }

    fun addShow(show: TraktShow, rating: Int? = null, ratedAt: ZonedDateTime? = null, seasons: PostRatingsSeasons? = null): TraktSyncRatingsPostBuilder {
        validateShow(show)
        if (rating != null)
            validateRating(rating)

        if (seasons != null)
            createOrSetShow(show, createShowSeasons(seasons), rating, ratedAt)
        else
            addShowOrIgnore(show, rating, ratedAt)

        return this
    }

    fun addEpisodes(episodes: Collection<TraktEpisode>): TraktSyncRatingsPostBuilder {
        if (episodes.isEmpty()) return this

        for (episode in episodes)
            addEpisode(episode)

        return this
    }

    fun addEpisode(episode: TraktEpisode, rating: Int? = null, ratedAt: ZonedDateTime? = null): TraktSyncRatingsPostBuilder {
        validateEpisode(episode)
        if (rating != null)
            validateRating(rating)

        return addEpisodeOrIgnore(episode, rating, ratedAt)
    }

    override fun reset() {
        ratingsPost.movies.clear()

        ratingsPost.shows.clear()

        ratingsPost.episodes.clear()
    }

    override fun build(): TraktSyncRatingsPostImpl {
        return ratingsPost
    }

    private fun validateRating(rating: Int) {
        if (rating < 1 || rating > 10) throw IllegalArgumentException("rating")
    }

    private fun containsMovie(movie: TraktMovie): Boolean {
        for ((_, _, ids) in ratingsPost.movies)
            if (ids like movie.ids) return true

        return false
    }

    private fun containsShow(show: TraktShow): Boolean {
        for ((_, _, ids) in ratingsPost.shows)
            if (ids like show.ids) return true

        return false
    }

    private fun containsEpisode(episode: TraktEpisode): Boolean {
        for ((ids) in ratingsPost.episodes)
            if (ids like episode.ids) return true

        return false
    }

    private fun addMovieOrIgnore(movie: TraktMovie, rating: Int? = null, ratedAt: ZonedDateTime? = null): TraktSyncRatingsPostBuilder {
        if (containsMovie(movie)) return this
        ratingsPost.movies.add(TraktSyncRatingsPostMovieImpl(movie.title, movie.year, movie.ids, rating, ratedAt))
        return this
    }

    private fun addShowOrIgnore(show: TraktShow, rating: Int? = null, ratedAt: ZonedDateTime? = null): TraktSyncRatingsPostBuilder {
        if (containsShow(show)) return this
        ratingsPost.shows.add(TraktSyncRatingsPostShowImpl(show.title, show.year, show.ids, rating, ratedAt))
        return this
    }

    private fun addEpisodeOrIgnore(episode: TraktEpisode, rating: Int? = null, ratedAt: ZonedDateTime? = null): TraktSyncRatingsPostBuilder {
        if (containsEpisode(episode)) return this
        ratingsPost.episodes.add(TraktSyncRatingsPostEpisodeImpl(episode.ids, rating, ratedAt))
        return this
    }

    private fun createOrSetShow(show: TraktShow, showSeasons: MutableList<TraktSyncRatingsPostShowSeasonImpl>, rating: Int? = null, ratedAt: ZonedDateTime? = null) {
        val existingShow = ratingsPost.shows.firstOrNull { s -> s.ids like show.ids }

        if (existingShow != null)
            existingShow.seasons = showSeasons
        else {
            val ratingsShow = TraktSyncRatingsPostShowImpl().apply {
                ids = show.ids
                title = show.title
                year = show.year
            }

            if (rating != null) ratingsShow.rating = rating

            if (ratedAt != null) ratingsShow.ratedAt = ratedAt

            ratingsShow.seasons = showSeasons

            ratingsPost.shows.add(ratingsShow)
        }
    }

    private fun createShowSeasons(vararg seasons: Int): MutableList<TraktSyncRatingsPostShowSeasonImpl> {
        val showSeasons = ArrayList<TraktSyncRatingsPostShowSeasonImpl>()

        for (season in seasons) {
            if (season < 0) throw IllegalArgumentException("at least one season number not valid")

            showSeasons.add(TraktSyncRatingsPostShowSeasonImpl(season))
        }

        return showSeasons
    }

    private fun createShowSeasons(seasons: PostRatingsSeasons): MutableList<TraktSyncRatingsPostShowSeasonImpl> {
        val showSeasons = ArrayList<TraktSyncRatingsPostShowSeasonImpl>()

        for (season in seasons) {
            if (season.number < 0) throw IllegalArgumentException("at least one season number not valid")

            val showSingleSeason = TraktSyncRatingsPostShowSeasonImpl(season.number, season.rating, season.ratedAt)

            if (season.episodes.size > 0) {
                val showEpisodes = ArrayList<TraktSyncRatingsPostShowEpisodeImpl>()

                for (episode in season.episodes) {
                    if (episode.number < 0)
                        throw IllegalArgumentException("at least one episode number not valid")

                    showEpisodes.add(TraktSyncRatingsPostShowEpisodeImpl(episode.number, episode.rating, episode.ratedAt))
                }

                showSingleSeason.episodes = showEpisodes
            }

            showSeasons.add(showSingleSeason)
        }

        return showSeasons
    }

    override fun self(): TraktSyncRatingsPostBuilder {
        return this
    }
}