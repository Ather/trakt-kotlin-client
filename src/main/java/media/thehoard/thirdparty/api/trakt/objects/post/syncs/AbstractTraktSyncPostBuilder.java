package media.thehoard.thirdparty.api.trakt.objects.post.syncs;

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;

public abstract class AbstractTraktSyncPostBuilder<BuildResult, BuilderReturn extends AbstractTraktSyncPostBuilder> {
	public abstract void reset();

	public abstract BuildResult build();

	protected void validateMovie(TraktMovie movie) {
		if (movie == null) throw new IllegalArgumentException("movie");

		if (movie.getIds() == null) throw new IllegalArgumentException("movie ids");

		if (!movie.getIds().hasAnyId()) throw new IllegalArgumentException("no movie ids set or valid");

		if (movie.getYear() != null && movie.getYear().toString().length() != 4)
			throw new IllegalArgumentException("movie year not valid");
	}

	protected void validateShow(TraktShow show) {
		if (show == null) throw new IllegalArgumentException("show");

		if (show.getIds() == null) throw new IllegalArgumentException("show ids");

		if (!show.getIds().hasAnyId()) throw new IllegalArgumentException("no show ids set or valid");

		if (show.getYear() != null && show.getYear().toString().length() != 4)
			throw new IllegalArgumentException("show year not valid");
	}

	protected void validateEpisode(TraktEpisode episode) {
		if (episode == null) throw new IllegalArgumentException("episode");

		if (episode.getIds() == null) throw new IllegalArgumentException("episode ids");

		if (!episode.getIds().hasAnyId()) throw new IllegalArgumentException("no episode ids set or valid");
	}

	protected void validateIds(TraktDefaultIds ids, String noun) {
		if (ids == null) throw new IllegalArgumentException(noun + " ids");

		if (!ids.hasAnyId()) throw new IllegalArgumentException("no " + noun + " ids set or valid");
	}

	/*
	protected abstract boolean containsMovie(TraktMovie movie);

	protected abstract boolean containsShow(TraktShow show);

	protected abstract boolean containsEpisode(TraktEpisode episode);*/

	protected abstract void ensureMoviesListExists();

	protected abstract void ensureShowsListExists();

	protected abstract void ensureEpisodesListExists();

	protected abstract BuilderReturn self();
}
