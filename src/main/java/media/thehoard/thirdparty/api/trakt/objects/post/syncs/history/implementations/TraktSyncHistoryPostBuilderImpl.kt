package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.post.PostHistorySeasons
import java.time.ZonedDateTime

class TraktSyncHistoryPostBuilderImpl : AbstractTraktSyncHistoryPostBuilder<TraktSyncHistoryPostImpl, TraktSyncHistoryPostBuilderImpl>() {
    private val historyPost: TraktSyncHistoryPostImpl = TraktSyncHistoryPostImpl()

    fun addMovie(movie: TraktMovie, watchedAt: ZonedDateTime? = null): TraktSyncHistoryPostBuilderImpl {
        movie.validate()

        return addMovieOrIgnore(movie, watchedAt)
    }

    fun addShow(show: TraktShow, watchedAt: ZonedDateTime? = null, vararg seasons: Int): TraktSyncHistoryPostBuilderImpl {
        show.validate()

        val showSeasons = createShowSeasons(*seasons)
        createOrSetShow(show, showSeasons, watchedAt)

        return this
    }

    fun addShow(show: TraktShow, watchedAt: ZonedDateTime? = null, seasons: PostHistorySeasons? = null): TraktSyncHistoryPostBuilderImpl {
        show.validate()

        val showSeasons = if (seasons != null) createShowSeasons(seasons) else null
        createOrSetShow(show, showSeasons, watchedAt)

        return this
    }

    fun addEpisode(episode: TraktEpisode, watchedAt: ZonedDateTime? = null): TraktSyncHistoryPostBuilderImpl {
        episode.validate()

        return addEpisodeOrIgnore(episode, watchedAt)
    }

    override fun reset() {
        historyPost.movies.clear()

        historyPost.shows.clear()

        historyPost.episodes.clear()
    }

    override fun build(): TraktSyncHistoryPostImpl {
        return historyPost
    }

    override fun containsMovie(movie: TraktMovie): Boolean {
        for (m in historyPost.movies)
            if (m.ids like movie.ids)
                return true

        return false
    }

    override fun containsShow(show: TraktShow): Boolean {
        for (s in historyPost.shows)
            if (s.ids like show.ids)
                return true

        return false
    }

    override fun containsEpisode(episode: TraktEpisode): Boolean {
        for ((_, ids) in historyPost.episodes)
            if (ids like episode.ids)
                return true

        return false
    }

    override fun addMovieOrIgnore(movie: TraktMovie): TraktSyncHistoryPostBuilderImpl = addMovieOrIgnore(movie, null)

    override fun addShowOrIgnore(show: TraktShow): TraktSyncHistoryPostBuilderImpl = addShowOrIgnore(show, null)

    override fun addEpisodeOrIgnore(episode: TraktEpisode): TraktSyncHistoryPostBuilderImpl = addEpisodeOrIgnore(episode, null)

    override fun createOrSetShow(show: TraktShow, showSeasons: MutableList<TraktSyncHistoryPostShowSeasonImpl>) = createOrSetShow(show, showSeasons, null)

    private fun addMovieOrIgnore(movie: TraktMovie, watchedAt: ZonedDateTime? = null): TraktSyncHistoryPostBuilderImpl {
        if (containsMovie(movie))
            return this

        val historyMovie = TraktSyncHistoryPostMovieImpl()
        historyMovie.ids = movie.ids
        historyMovie.title = movie.title
        historyMovie.year = movie.year

        if (watchedAt != null)
            historyMovie.watchedAt = watchedAt

        historyPost.movies.add(historyMovie)

        return this
    }

    private fun addShowOrIgnore(show: TraktShow, watchedAt: ZonedDateTime? = null): TraktSyncHistoryPostBuilderImpl {
        if (containsShow(show))
            return this

        val historyShow = TraktSyncHistoryPostShowImpl()
        historyShow.ids = show.ids
        historyShow.title = show.title
        historyShow.year = show.year

        if (watchedAt != null)
            historyShow.watchedAt = watchedAt

        historyPost.shows.add(historyShow)

        return this
    }

    private fun addEpisodeOrIgnore(episode: TraktEpisode, watchedAt: ZonedDateTime? = null): TraktSyncHistoryPostBuilderImpl {
        if (containsEpisode(episode))
            return this

        val historyEpisode = TraktSyncHistoryPostEpisodeImpl()
        historyEpisode.ids = episode.ids

        if (watchedAt != null)
            historyEpisode.watchedAt = watchedAt

        historyPost.episodes.add(historyEpisode)

        return this
    }

    private fun createOrSetShow(show: TraktShow, showSeasons: MutableList<TraktSyncHistoryPostShowSeasonImpl>? = null, watchedAt: ZonedDateTime? = null) {
        val existingShow = historyPost.shows.firstOrNull { s -> s.ids like show.ids }

        if (existingShow != null && showSeasons != null)
            existingShow.seasons = showSeasons
        else {
            val historyShow = TraktSyncHistoryPostShowImpl()
            historyShow.ids = show.ids
            historyShow.title = show.title
            historyShow.year = show.year

            if (watchedAt != null)
                historyShow.watchedAt = watchedAt

            if (showSeasons != null)
                historyShow.seasons = showSeasons

            historyPost.shows.add(historyShow)
        }
    }

    override fun self(): TraktSyncHistoryPostBuilderImpl {
        return this
    }
}