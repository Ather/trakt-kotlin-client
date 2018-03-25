package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.PostSeasons;
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.AbstractTraktSyncPostBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TraktSyncWatchlistPostImpl {
	private List<TraktSyncWatchlistPostMovieImpl> movies;
	private List<TraktSyncWatchlistPostShowImpl> shows;
	private List<TraktSyncWatchlistPostEpisodeImpl> episodes;

	public static TraktSyncWatchlistPostBuilder builder() {
		return new TraktSyncWatchlistPostBuilder();
	}

	public static final class TraktSyncWatchlistPostBuilder
			extends AbstractTraktSyncPostBuilder<TraktSyncWatchlistPostImpl, TraktSyncWatchlistPostBuilder> {
		private TraktSyncWatchlistPostImpl watchlistPost;

		public TraktSyncWatchlistPostBuilder() {
			this.watchlistPost = new TraktSyncWatchlistPostImpl();
		}

		public TraktSyncWatchlistPostBuilder addMovie(TraktMovieImpl movie) {
			if (movie == null)
				throw new IllegalArgumentException("movie");

			if (movie.ids == null)
				throw new IllegalArgumentException("movie ids");

			if (!movie.ids.hasAnyId())
				throw new IllegalArgumentException("no movie ids set or valid");

			if (movie.year != null && movie.year.toString().length() != 4)
				throw new IllegalArgumentException("movie year not valid");

			ensureMoviesListExists();

			TraktSyncWatchlistPostMovieImpl existingMovie = watchlistPost.movies.stream().filter(m -> m.ids == movie.ids)
					.findFirst().orElseGet(null);
			
			if (existingMovie != null)
				return this;
			
			watchlistPost.movies.add(new TraktSyncWatchlistPostMovieImpl(movie.ids, movie.title, movie.year));
			
			return this;
		}

		public TraktSyncWatchlistPostBuilder addMovies(Collection<TraktMovieImpl> movies) {
			if (movies == null)
				throw new IllegalArgumentException("movies");
			
			if (movies.size() == 0)
				return this;

			for (TraktMovieImpl movie : movies)
				addMovie(movie);
			
			return this;
		}

		public TraktSyncWatchlistPostBuilder addShow(TraktShowImpl show) {
			validateShow(show);
			ensureShowsListExists();

			TraktSyncWatchlistPostShowImpl existingShow = watchlistPost.shows.stream().filter(s -> s.ids == show.ids)
					.findFirst().orElse(null);
			
			if (existingShow != null)
				return this;
			
			watchlistPost.shows.add(new TraktSyncWatchlistPostShowImpl(show.ids, show.title, show.year));
			
			return this;
		}

		public TraktSyncWatchlistPostBuilder addShows(Collection<TraktShow> shows) {
			if (shows == null)
				throw new IllegalArgumentException("shows");

			if (shows.size() == 0)
				return this;

			for (TraktShowImpl show : shows)
				addShow(show);

			return this;
		}

		public TraktSyncWatchlistPostBuilder addShow(TraktShowImpl show, int... seasons) {
			validateShow(show);
			ensureShowsListExists();

			if (seasons == null)
				throw new IllegalArgumentException("seasons");

			List<TraktSyncWatchlistPostShowSeasonImpl> showSeasons = new ArrayList<>();

			for (int season : seasons) {
				if (season < 0)
					throw new IllegalArgumentException("at least one season number not valid");

				showSeasons.add(new TraktSyncWatchlistPostShowSeasonImpl(season));
			}

			TraktSyncWatchlistPostShowImpl existingShow = watchlistPost.shows.stream().filter(s -> s.ids == show.ids)
					.findFirst().orElse(null);

			if (existingShow != null)
				existingShow.seasons = showSeasons;
			else {
				TraktSyncWatchlistPostShowImpl watchlistShow = new TraktSyncWatchlistPostShowImpl();
				watchlistShow.ids = show.ids;
				watchlistShow.title = show.title;
				watchlistShow.year = show.year;

				watchlistShow.seasons = showSeasons;

				watchlistPost.shows.add(watchlistShow);
			}

			return this;
		}

		public TraktSyncWatchlistPostBuilder addShow(TraktShowImpl show, PostSeasons seasons) {
			validateShow(show);
			ensureShowsListExists();

			if (watchlistPost.shows == null)
				watchlistPost.shows = new ArrayList<>();

			List<TraktSyncWatchlistPostShowSeasonImpl> showSeasons = null;

			if (seasons.size() > 0) {
				showSeasons = new ArrayList<>();

				for (PostSeasons.PostSeason season : seasons) {
					if (season.getNumber() < 0)
						throw new IllegalArgumentException("at least one season number not valid");

					TraktSyncWatchlistPostShowSeasonImpl showSingleSeason = new TraktSyncWatchlistPostShowSeasonImpl(season.getNumber());

					if (season.getEpisodes() != null && season.getEpisodes().size() > 0) {
						List<TraktSyncWatchlistPostShowEpisodeImpl> showEpisodes = new ArrayList<>();

						for (int episode : season.getEpisodes()) {
							if (episode < 0)
								throw new IllegalArgumentException("at least one episode number not valid");

							showEpisodes.add(new TraktSyncWatchlistPostShowEpisodeImpl(episode));
						}

						showSingleSeason.episodes = showEpisodes;
					}

					showSeasons.add(showSingleSeason);
				}
			}

			TraktSyncWatchlistPostShowImpl existingShow = watchlistPost.shows.stream().filter(s -> s.ids == show.ids)
					.findFirst().orElse(null);

			if (existingShow != null)
				existingShow.seasons = showSeasons;
			else {
				TraktSyncWatchlistPostShowImpl watchlistShow = new TraktSyncWatchlistPostShowImpl();
				watchlistShow.ids = show.ids;
				watchlistShow.title = show.title;
				watchlistShow.year = show.year;

				watchlistShow.seasons = showSeasons;

				watchlistPost.shows.add(watchlistShow);
			}

			return this;
		}

		public TraktSyncWatchlistPostBuilder addEpisode(TraktEpisodeImpl episode) {
			if (episode == null)
				throw new IllegalArgumentException("episode");

			if (episode.ids == null)
				throw new IllegalArgumentException("episode ids");
			
			if (!episode.ids.hasAnyId())
				throw new IllegalArgumentException("no episode ids set or valid");
			
			ensureEpisodesListExists();

			TraktSyncWatchlistPostEpisodeImpl existingEpisode = watchlistPost.episodes.stream().filter(e -> e.ids == episode.ids)
					.findFirst().orElse(null);

			if (existingEpisode != null)
				return this;

			watchlistPost.episodes.add(new TraktSyncWatchlistPostEpisodeImpl(episode.ids));

			return this;
		}

		public TraktSyncWatchlistPostBuilder addEpisode(Collection<TraktEpisode> episodes) {
			if (episodes == null)
				throw new IllegalArgumentException("episodes");

			if (episodes.size() == 0)
				return this;

			for (TraktEpisodeImpl episode : episodes)
				addEpisode(episode);

			return this;
		}

		@Override
		public void reset() {
			if (watchlistPost.movies != null) {
				watchlistPost.movies.clear();
				watchlistPost.movies = null;
			}

			if (watchlistPost.shows != null) {
				watchlistPost.shows.clear();
				watchlistPost.shows = null;
			}

			if (watchlistPost.episodes != null) {
				watchlistPost.episodes.clear();
				watchlistPost.episodes = null;
			}
		}

		@Override
		public TraktSyncWatchlistPostImpl build() {
			return watchlistPost;
		}

		@Override
		protected void ensureMoviesListExists() {
			if (watchlistPost.movies == null)
				watchlistPost.movies = new ArrayList<>();
		}

		@Override
		protected void ensureShowsListExists() {
			if (watchlistPost.shows == null)
				watchlistPost.shows = new ArrayList<>();
		}

		@Override
		protected void ensureEpisodesListExists() {
			if (watchlistPost.episodes == null)
				watchlistPost.episodes = new ArrayList<>();
		}

		@Override
		protected TraktSyncWatchlistPostBuilder self() {
			return this;
		}
	}
}
