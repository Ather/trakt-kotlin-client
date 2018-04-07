package media.thehoard.thirdparty.api.trakt.objects.post.syncs

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

abstract class AbstractTraktSyncPostBuilder<BuildResult, BuilderReturn : AbstractTraktSyncPostBuilder<BuildResult, BuilderReturn>> {
    abstract fun reset()

    abstract fun build(): BuildResult

    protected open fun validateMovie(movie: TraktMovie) {
        if (!movie.ids.hasAnyId()) throw IllegalArgumentException("no movie ids set or valid")

        if (movie.year.toString().length != 4)
            throw IllegalArgumentException("movie year not valid")
    }

    protected open fun validateShow(show: TraktShow) {
        if (!show.ids.hasAnyId()) throw IllegalArgumentException("no show ids set or valid")

        if (show.year.toString().length != 4)
            throw IllegalArgumentException("show year not valid")
    }

    protected open fun validateEpisode(episode: TraktEpisode) {
        if (!episode.ids.hasAnyId()) throw IllegalArgumentException("no episode ids set or valid")
    }

    protected fun validateIds(ids: TraktDefaultIds, noun: String) {
        if (!ids.hasAnyId()) throw IllegalArgumentException("no $noun ids set or valid")
    }

    /*
	protected abstract boolean containsMovie(TraktMovie movie);

	protected abstract boolean containsShow(TraktShow show);

	protected abstract boolean containsEpisode(TraktEpisode episode);*/

    protected abstract fun self(): BuilderReturn
}
