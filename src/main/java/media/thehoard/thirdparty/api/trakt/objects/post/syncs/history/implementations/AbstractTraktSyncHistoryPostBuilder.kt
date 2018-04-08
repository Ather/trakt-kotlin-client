package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.post.PostHistorySeasons
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.AbstractTraktSyncPostBuilder
import java.util.*

abstract class AbstractTraktSyncHistoryPostBuilder<BuildResult, BuilderReturn : AbstractTraktSyncHistoryPostBuilder<BuildResult, BuilderReturn>> : AbstractTraktSyncPostBuilder<BuildResult, BuilderReturn>() {
    fun addMovie(movie: TraktMovie): BuilderReturn {
        movie.validate()

        return addMovieOrIgnore(movie)
    }

    fun addMovies(movies: Collection<TraktMovie>): BuilderReturn {
        if (movies.isEmpty()) return self()

        for (movie in movies)
            addMovie(movie)

        return self()
    }

    fun addShows(shows: Collection<TraktShow>): BuilderReturn {
        if (shows.isEmpty()) return self()

        for (show in shows)
            addShow(show)

        return self()
    }

    fun addShow(show: TraktShow, vararg seasons: Int): BuilderReturn {
        show.validate()

        if (seasons.isNotEmpty()) {
            val showSeasons = createShowSeasons(*seasons)
            createOrSetShow(show, showSeasons)
        }

        return self()
    }

    fun addShow(show: TraktShow, seasons: PostHistorySeasons): BuilderReturn {
        show.validate()

        val showSeasons = createShowSeasons(seasons)
        createOrSetShow(show, showSeasons)

        return self()
    }

    fun addEpisode(episode: TraktEpisode): BuilderReturn {
        episode.validate()

        return addEpisodeOrIgnore(episode)
    }

    fun addEpisodes(episodes: Collection<TraktEpisode>): BuilderReturn {
        if (episodes.isEmpty()) return self()

        for (episode in episodes)
            addEpisode(episode)

        return self()
    }

    protected abstract fun containsMovie(movie: TraktMovie): Boolean

    protected abstract fun containsShow(show: TraktShow): Boolean

    protected abstract fun containsEpisode(episode: TraktEpisode): Boolean

    protected abstract fun addMovieOrIgnore(movie: TraktMovie): BuilderReturn

    protected abstract fun addShowOrIgnore(show: TraktShow): BuilderReturn

    protected abstract fun addEpisodeOrIgnore(episode: TraktEpisode): BuilderReturn

    protected abstract fun createOrSetShow(show: TraktShow, showSeasons: MutableList<TraktSyncHistoryPostShowSeasonImpl>)

    protected fun createShowSeasons(vararg seasons: Int): MutableList<TraktSyncHistoryPostShowSeasonImpl> {
        val showSeasons = ArrayList<TraktSyncHistoryPostShowSeasonImpl>()

        for (season in seasons) {
            if (season < 0) throw IllegalArgumentException("at least one season number not valid")

            showSeasons.add(TraktSyncHistoryPostShowSeasonImpl(number = season))
        }

        return showSeasons
    }

    protected fun createShowSeasons(seasons: PostHistorySeasons): MutableList<TraktSyncHistoryPostShowSeasonImpl> {
        val showSeasons = ArrayList<TraktSyncHistoryPostShowSeasonImpl>()

        for (season in seasons) {
            if (season.number < 0) throw IllegalArgumentException("at least one season number not valid")

            val showSingleSeason = TraktSyncHistoryPostShowSeasonImpl(number = season.number)

            if (season.watchedAt != null) showSingleSeason.watchedAt = season.watchedAt

            if (season.episodes.size > 0) {
                val showEpisodes = ArrayList<TraktSyncHistoryPostShowEpisodeImpl>()

                for (episode in season.episodes) {
                    if (episode.number < 0)
                        throw IllegalArgumentException("at least one episode nubmer not valid")

                    showEpisodes.add(TraktSyncHistoryPostShowEpisodeImpl().apply { number = episode.number; watchedAt = episode.watchedAt })
                }

                showSingleSeason.episodes = showEpisodes
            }

            showSeasons.add(showSingleSeason)
        }

        return showSeasons
    }
}
