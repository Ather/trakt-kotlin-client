package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.post.PostHistoryEpisodes;
import media.thehoard.thirdparty.api.trakt.objects.post.PostHistorySeasons;
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.AbstractTraktSyncPostBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractTraktSyncHistoryPostBuilder<BuildResult, BuilderReturn extends AbstractTraktSyncHistoryPostBuilder>
		extends AbstractTraktSyncPostBuilder<BuildResult, BuilderReturn> {
	public BuilderReturn addMovie(TraktMovie movie) {
		validateMovie(movie);
		ensureMoviesListExists();

		return addMovieOrIgnore(movie);
	}

	public BuilderReturn addMovies(Collection<TraktMovie> movies) {
		if (movies == null) throw new IllegalArgumentException("movies");

		if (movies.size() == 0) return self();

		for (TraktMovie movie : movies)
			addMovie(movie);

		return self();
	}

	public BuilderReturn addShow(TraktShow show) {
		validateShow(show);
		ensureShowsListExists();

		return addShowOrIgnore(show);
	}

	public BuilderReturn addShows(Collection<TraktShow> shows) {
		if (shows == null) throw new IllegalArgumentException("shows");

		if (shows.size() == 0) return self();

		for (TraktShow show : shows)
			addShow(show);

		return self();
	}

	public BuilderReturn addShow(TraktShow show, int... seasons) {
		validateShow(show);
		ensureShowsListExists();

		List<TraktSyncHistoryPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
		createOrSetShow(show, showSeasons);

		return self();
	}

	public BuilderReturn addShow(TraktShow show, PostHistorySeasons seasons) {
		validateShow(show);

		if (seasons == null) throw new IllegalArgumentException("seasons");

		ensureShowsListExists();

		List<TraktSyncHistoryPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
		createOrSetShow(show, showSeasons);

		return self();
	}

	public BuilderReturn addEpisode(TraktEpisode episode) {
		validateEpisode(episode);
		ensureEpisodesListExists();

		return addEpisodeOrIgnore(episode);
	}

	public BuilderReturn addEpisodes(Collection<TraktEpisode> episodes) {
		if (episodes == null) throw new IllegalArgumentException("episodes");

		if (episodes.size() == 0) return self();

		for (TraktEpisode episode : episodes)
			addEpisode(episode);

		return self();
	}

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

	protected abstract boolean containsMovie(TraktMovie movie);

	protected abstract boolean containsShow(TraktShow show);

	protected abstract boolean containsEpisode(TraktEpisode episode);

	protected abstract void ensureMoviesListExists();

	protected abstract void ensureShowsListExists();

	protected abstract void ensureEpisodesListExists();

	protected abstract BuilderReturn addMovieOrIgnore(TraktMovie movie);

	protected abstract BuilderReturn addShowOrIgnore(TraktShow show);

	protected abstract BuilderReturn addEpisodeOrIgnore(TraktEpisode episode);

	protected abstract void createOrSetShow(TraktShow show, List<TraktSyncHistoryPostShowSeasonImpl> showSeasons);

	protected List<TraktSyncHistoryPostShowSeasonImpl> createShowSeasons(int... seasons) {
		List<TraktSyncHistoryPostShowSeasonImpl> showSeasons = new ArrayList<>();

		for (int season : seasons) {
			if (season < 0) throw new IllegalArgumentException("at least one season number not valid");

			showSeasons.add(new TraktSyncHistoryPostShowSeasonImpl(season));
		}

		return showSeasons;
	}

	protected List<TraktSyncHistoryPostShowSeasonImpl> createShowSeasons(PostHistorySeasons seasons) {
		List<TraktSyncHistoryPostShowSeasonImpl> showSeasons = new ArrayList<>();

		for (PostHistorySeasons.PostHistorySeason season : seasons) {
			if (season.number < 0) throw new IllegalArgumentException("at least one season number not valid");

			TraktSyncHistoryPostShowSeasonImpl showSingleSeason = new TraktSyncHistoryPostShowSeasonImpl(season.number);

			if (season.watchedAt != null) showSingleSeason.watchedAt = season.watchedAt;

			if (season.episodes != null && season.episodes.size() > 0) {
				List<TraktSyncHistoryPostShowEpisodeImpl> showEpisodes = new ArrayList<>();

				for (PostHistoryEpisodes.PostHistoryEpisode episode : season.episodes) {
					if (episode.number < 0) throw new IllegalArgumentException("at least one episode nubmer not valid");

					showEpisodes.add(new TraktSyncHistoryPostShowEpisodeImpl(episode));
				}

				showSingleSeason.episodes = showEpisodes;
			}

			showSeasons.add(showSingleSeason);
		}

		return showSeasons;
	}
}
