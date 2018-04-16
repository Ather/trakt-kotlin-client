package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.post.PostSeasons
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.AbstractTraktSyncPostBuilder
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPost
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostShowEpisode
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.TraktSyncWatchlistPostShowSeason
import java.util.*

class TraktSyncWatchlistPostBuilderImpl : AbstractTraktSyncPostBuilder<TraktSyncWatchlistPost, TraktSyncWatchlistPostBuilderImpl>() {
    private val watchlistPost: TraktSyncWatchlistPostImpl = TraktSyncWatchlistPostImpl()

    fun addMovie(movie: TraktMovie): TraktSyncWatchlistPostBuilderImpl {
        if (!movie.ids.hasAnyId())
            throw IllegalArgumentException("no movie ids set or valid")

        if (movie.year.toString().length != 4)
            throw IllegalArgumentException("movie year not valid")

        val existingMovie = watchlistPost.movies.firstOrNull { m -> m.ids like movie.ids }

        if (existingMovie != null)
            return this

        watchlistPost.movies.add(TraktSyncWatchlistPostMovieImpl(movie.title, movie.year, movie.ids))

        return this
    }

    fun addMovies(movies: Collection<TraktMovie>): TraktSyncWatchlistPostBuilderImpl {
        if (movies.isEmpty())
            return this

        for (movie in movies)
            addMovie(movie)

        return this
    }

    fun addShows(shows: Collection<TraktShow>): TraktSyncWatchlistPostBuilderImpl {
        if (shows.isEmpty())
            return this

        for (show in shows)
            addShow(show)

        return this
    }

    fun addShow(show: TraktShow, vararg seasons: Int): TraktSyncWatchlistPostBuilderImpl {
        show.validate()

        val showSeasons = ArrayList<TraktSyncWatchlistPostShowSeason>()

        for (season in seasons) {
            if (season < 0)
                throw IllegalArgumentException("at least one season number not valid")

            showSeasons.add(TraktSyncWatchlistPostShowSeasonImpl(season))
        }

        val existingShow = watchlistPost.shows.firstOrNull { s -> s.ids like show.ids }

        if (existingShow != null)
            existingShow.seasons = showSeasons
        else
            watchlistPost.shows.add(TraktSyncWatchlistPostShowImpl(show.title, show.year, show.ids, showSeasons))

        return this
    }

    fun addShow(show: TraktShow, seasons: PostSeasons): TraktSyncWatchlistPostBuilderImpl {
        show.validate()

        val showSeasons: MutableList<TraktSyncWatchlistPostShowSeason> = mutableListOf()

        if (seasons.size > 0) {
            for (season in seasons) {
                if (season.number < 0)
                    throw IllegalArgumentException("at least one season number not valid")

                val showSingleSeason = TraktSyncWatchlistPostShowSeasonImpl(season.number)

                if (season.episodes.isNotEmpty()) {
                    val showEpisodes = ArrayList<TraktSyncWatchlistPostShowEpisode>()

                    for (episode in season.episodes) {
                        if (episode < 0)
                            throw IllegalArgumentException("at least one episode number not valid")

                        showEpisodes.add(TraktSyncWatchlistPostShowEpisodeImpl(episode))
                    }

                    showSingleSeason.episodes = showEpisodes
                }

                showSeasons.add(showSingleSeason)
            }
        }

        val existingShow = watchlistPost.shows.firstOrNull { s -> s.ids like show.ids }

        if (existingShow != null)
            existingShow.seasons = showSeasons
        else
            watchlistPost.shows.add(TraktSyncWatchlistPostShowImpl(show.title, show.year, show.ids, showSeasons))

        return this
    }

    fun addEpisode(episode: TraktEpisode): TraktSyncWatchlistPostBuilderImpl {
        if (!episode.ids.hasAnyId())
            throw IllegalArgumentException("no episode ids set or valid")

        val existingEpisode = watchlistPost.episodes.firstOrNull { ep -> ep.ids like episode.ids }

        if (existingEpisode != null)
            return this

        watchlistPost.episodes.add(TraktSyncWatchlistPostEpisodeImpl(episode.ids))

        return this
    }

    fun addEpisode(episodes: Collection<TraktEpisode>): TraktSyncWatchlistPostBuilderImpl {
        if (episodes.isEmpty())
            return this

        for (episode in episodes)
            addEpisode(episode)

        return this
    }

    override fun reset() {
        watchlistPost.movies.clear()

        watchlistPost.shows.clear()

        watchlistPost.episodes.clear()
    }

    override fun build(): TraktSyncWatchlistPostImpl {
        return watchlistPost
    }

    override fun self(): TraktSyncWatchlistPostBuilderImpl {
        return this
    }
}