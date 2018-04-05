package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

class TraktSyncHistoryRemovePostBuilder : AbstractTraktSyncHistoryPostBuilder<TraktSyncHistoryRemovePostImpl, TraktSyncHistoryRemovePostBuilder>() {
    private val historyPost: TraktSyncHistoryRemovePostImpl = TraktSyncHistoryRemovePostImpl()

    fun addHistoryIds(vararg ids: Long): TraktSyncHistoryRemovePostBuilder {
        for (id in ids) {
            if (id == 0L)
                throw IllegalArgumentException("at least one history id is not valid")

            historyPost.ids.add(id)
        }

        return this
    }

    override fun reset() {
        historyPost.movies.clear()

        historyPost.shows.clear()

        historyPost.episodes.clear()
    }

    override fun build(): TraktSyncHistoryRemovePostImpl {
        return historyPost
    }

    //TODO Consider the equality test used in these methods.
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

    override fun addMovieOrIgnore(movie: TraktMovie): TraktSyncHistoryRemovePostBuilder {
        if (containsMovie(movie))
            return this

        val historyMovie = TraktSyncHistoryPostMovieImpl()
        historyMovie.ids = movie.ids
        historyMovie.title = movie.title
        historyMovie.year = movie.year

        historyPost.movies.add(historyMovie)

        return this
    }

    override fun addShowOrIgnore(show: TraktShow): TraktSyncHistoryRemovePostBuilder {
        if (containsShow(show))
            return this

        val historyShow = TraktSyncHistoryPostShowImpl()
        historyShow.ids = show.ids
        historyShow.title = show.title
        historyShow.year = show.year

        historyPost.shows.add(historyShow)

        return this
    }

    override fun addEpisodeOrIgnore(episode: TraktEpisode): TraktSyncHistoryRemovePostBuilder {
        if (containsEpisode(episode))
            return this

        val historyEpisode = TraktSyncHistoryPostEpisodeImpl()
        historyEpisode.ids = episode.ids

        historyPost.episodes.add(historyEpisode)

        return this
    }

    //TODO Equality check
    override fun createOrSetShow(show: TraktShow, showSeasons: MutableList<TraktSyncHistoryPostShowSeasonImpl>) {
        val existingShow = historyPost.shows.firstOrNull { s -> s.ids like show.ids }

        if (existingShow != null)
            existingShow.seasons = showSeasons
        else {
            val historyShow = TraktSyncHistoryPostShowImpl()
            historyShow.ids = show.ids
            historyShow.title = show.title
            historyShow.year = show.year

            historyShow.seasons = showSeasons

            historyPost.shows.add(historyShow)
        }
    }

    override fun self(): TraktSyncHistoryRemovePostBuilder {
        return this
    }
}