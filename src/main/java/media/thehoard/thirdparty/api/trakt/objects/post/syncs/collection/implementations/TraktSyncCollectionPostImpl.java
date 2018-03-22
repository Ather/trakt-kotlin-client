package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktMetadata;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.post.PostSeasons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TraktSyncCollectionPostImpl {
	private List<TraktSyncCollectionPostMovieImpl> movies;
	private List<TraktSyncCollectionPostShowImpl> shows;
	private List<TraktSyncCollectionPostEpisodeImpl> episodes;

	public static TraktSyncCollectionPostBuilder builder() {
		return new TraktSyncCollectionPostBuilder();
	}

	public static class TraktSyncCollectionPostBuilder {
		private TraktSyncCollectionPostImpl collectionPost;

		public TraktSyncCollectionPostBuilder() {
			this.collectionPost = new TraktSyncCollectionPostImpl();
		}

		public TraktSyncCollectionPostBuilder addMovie(TraktMovie movie) {
			validateMovie(movie);
			ensureMoviesListExists();

			return addMovieOrIgnore(movie);
		}

		public TraktSyncCollectionPostBuilder addMovies(Collection<TraktMovie> movies) {
			if (movies == null) throw new IllegalArgumentException("movies");

			if (movies.size() == 0) return this;

			for (TraktMovie movie : movies)
				addMovie(movie);

			return this;
		}

		public TraktSyncCollectionPostBuilder addMovie(TraktMovie movie, Date collectedAt) {
			validateMovie(movie);
			ensureMoviesListExists();

			return addMovieOrIgnore(movie, null, collectedAt);
		}

		public TraktSyncCollectionPostBuilder addMovie(TraktMovie movie, TraktMetadata metadata) {
			validateMovie(movie);
			ensureMoviesListExists();

			return addMovieOrIgnore(movie, metadata);
		}

		public TraktSyncCollectionPostBuilder addMovie(TraktMovie movie, TraktMetadata metadata, Date collectedAt) {
			validateMovie(movie);
			ensureMoviesListExists();

			return addMovieOrIgnore(movie, metadata, collectedAt);
		}

		public TraktSyncCollectionPostBuilder addShow(TraktShow show) {
			validateShow(show);
			ensureShowsListExists();

			return addShowOrIgnore(show);
		}

		public TraktSyncCollectionPostBuilder addShows(Collection<TraktShow> shows) {
			if (shows == null) throw new IllegalArgumentException("shows");

			if (shows.size() == 0) return this;

			for (TraktShow show : shows)
				addShow(show);

			return this;
		}

		public TraktSyncCollectionPostBuilder addShow(TraktShow show, Date collectedAt) {
			validateShow(show);
			ensureShowsListExists();

			return addShowOrIgnore(show, null, collectedAt);
		}

		public TraktSyncCollectionPostBuilder addShow(TraktShow show, TraktMetadata metadata) {
			validateShow(show);
			ensureShowsListExists();

			return addShowOrIgnore(show, metadata);
		}

		public TraktSyncCollectionPostBuilder addShow(TraktShow show, TraktMetadata metadata, Date collectedAt) {
			validateShow(show);
			ensureShowsListExists();

			return addShowOrIgnore(show, metadata, collectedAt);
		}

		public TraktSyncCollectionPostBuilder addShow(TraktShow show, int... seasons) {
			validateShow(show);
			ensureShowsListExists();

			List<TraktSyncCollectionPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons);

			return this;
		}

		public TraktSyncCollectionPostBuilder addShow(TraktShow show, Date collectedAt, int... seasons) {
			validateShow(show);
			ensureShowsListExists();

			List<TraktSyncCollectionPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons, null, collectedAt);

			return this;
		}

		public TraktSyncCollectionPostBuilder addShow(TraktShow show, TraktMetadata metadata, int... seasons) {
			validateShow(show);
			ensureShowsListExists();

			List<TraktSyncCollectionPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons, metadata);

			return this;
		}

		public TraktSyncCollectionPostBuilder addShow(TraktShow show, TraktMetadata metadata, Date collectedAt, int... seasons) {
			validateShow(show);
			ensureShowsListExists();

			List<TraktSyncCollectionPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons, metadata, collectedAt);

			return this;
		}

		public TraktSyncCollectionPostBuilder addShow(TraktShow show, PostSeasons seasons) {
			validateShow(show);

			if (seasons == null) throw new IllegalArgumentException("seasons");

			ensureShowsListExists();

			List<TraktSyncCollectionPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons);

			return this;
		}

		public TraktSyncCollectionPostBuilder addShow(TraktShow show, Date collectedAt, PostSeasons seasons) {
			validateShow(show);

			if (seasons == null) throw new IllegalArgumentException("seasons");

			ensureShowsListExists();

			List<TraktSyncCollectionPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons, null, collectedAt);

			return this;
		}

		public TraktSyncCollectionPostBuilder addShow(TraktShow show, TraktMetadata metadata, PostSeasons seasons) {
			validateShow(show);

			if (seasons == null) throw new IllegalArgumentException("seasons");

			ensureShowsListExists();

			List<TraktSyncCollectionPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons, metadata);

			return this;
		}

		public TraktSyncCollectionPostBuilder addShow(TraktShow show, TraktMetadata metadata, Date collectedAt, PostSeasons seasons) {
			validateShow(show);

			if (seasons == null) throw new IllegalArgumentException("seasons");

			ensureShowsListExists();

			List<TraktSyncCollectionPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons, metadata, collectedAt);

			return this;
		}

		public TraktSyncCollectionPostBuilder addEpisode(TraktEpisode episode) {
			validateEpisode(episode);
			ensureEpisodesListExists();

			return addEpisodeOrIgnore(episode);
		}

		public TraktSyncCollectionPostBuilder addEpisodes(Collection<TraktEpisode> episodes) {
			if (episodes == null) throw new IllegalArgumentException("episodes");

			if (episodes.size() == 0) return this;

			for (TraktEpisode episode : episodes)
				addEpisode(episode);

			return this;
		}

		public TraktSyncCollectionPostBuilder addEpisode(TraktEpisode episode, Date collectedAt) {
			validateEpisode(episode);
			ensureEpisodesListExists();

			return addEpisodeOrIgnore(episode, null, collectedAt);
		}

		public TraktSyncCollectionPostBuilder addEpisode(TraktEpisode episode, TraktMetadata metadata) {
			validateEpisode(episode);
			ensureEpisodesListExists();

			return addEpisodeOrIgnore(episode, metadata);
		}

		public TraktSyncCollectionPostBuilder addEpisode(TraktEpisode episode, TraktMetadata metadata, Date collectedAt) {
			validateEpisode(episode);
			ensureEpisodesListExists();

			return addEpisodeOrIgnore(episode, metadata, collectedAt);
		}

		public void reset() {
			if (collectionPost.movies != null) {
				collectionPost.movies.clear();
				collectionPost.movies = null;
			}

			if (collectionPost.shows != null) {
				collectionPost.shows.clear();
				collectionPost.shows = null;
			}

			if (collectionPost.episodes != null) {
				collectionPost.episodes.clear();
				collectionPost.episodes = null;
			}
		}

		public TraktSyncCollectionPostImpl build() {
			return collectionPost;
		}

		private void validateMovie(TraktMovie movie) {
			if (movie == null) throw new IllegalArgumentException("movie");

			if (movie.getIds() == null) throw new IllegalArgumentException("movie ids");

			if (!movie.getIds().hasAnyId()) throw new IllegalArgumentException("no movie ids set or valid");

			if (movie.getYear() != null && movie.getYear().toString().length() != 4)
				throw new IllegalArgumentException("movie year not valid");
		}

		private void validateShow(TraktShow show) {
			if (show == null) throw new IllegalArgumentException("show");

			if (show.getIds() == null) throw new IllegalArgumentException("show ids");

			if (!show.getIds().hasAnyId()) throw new IllegalArgumentException("no show ids set or valid");

			if (show.getYear() != null && show.getYear().toString().length() != 4)
				throw new IllegalArgumentException("show year not valid");
		}

		private void validateEpisode(TraktEpisode episode) {
			if (episode == null) throw new IllegalArgumentException("episode");

			if (episode.getIds() == null) throw new IllegalArgumentException("episode ids");

			if (!episode.getIds().hasAnyId()) throw new IllegalArgumentException("no episode ids set or valid");
		}

		//TODO Consider the equality test used in these methods.
		private boolean containsMovie(TraktMovie movie) {
			for (TraktSyncCollectionPostMovieImpl m : collectionPost.movies)
				if (m.ids == movie.getIds()) return true;

			return false;
		}

		private void ensureMoviesListExists() {
			if (collectionPost.movies == null) collectionPost.movies = new ArrayList<>();
		}

		private boolean containsShow(TraktShow show) {
			for (TraktSyncCollectionPostShowImpl s : collectionPost.shows)
				if (s.ids == show.getIds()) return true;

			return false;
		}

		private void ensureShowsListExists() {
			if (collectionPost.shows == null) collectionPost.shows = new ArrayList<>();
		}

		private boolean containsEpisode(TraktEpisode episode) {
			for (TraktSyncCollectionPostEpisodeImpl e : collectionPost.episodes)
				if (e.ids == episode.getIds()) return true;

			return false;
		}

		private void ensureEpisodesListExists() {
			if (collectionPost.episodes == null) collectionPost.episodes = new ArrayList<>();
		}

		private TraktSyncCollectionPostBuilder addMovieOrIgnore(TraktMovie movie, TraktMetadata metadata, Date collectedAt) {
			if (containsMovie(movie)) return this;

			TraktSyncCollectionPostMovieImpl collectionMovie = new TraktSyncCollectionPostMovieImpl();
			collectionMovie.ids = movie.getIds();
			collectionMovie.title = movie.getTitle();
			collectionMovie.year = movie.getYear();

			if (metadata != null) collectionMovie.metadata = metadata;

			if (collectedAt != null) collectionMovie.collectedAt = collectedAt;

			collectionPost.movies.add(collectionMovie);

			return this;
		}

		private TraktSyncCollectionPostBuilder addMovieOrIgnore(TraktMovie movie, TraktMetadata metadata) {
			return addMovieOrIgnore(movie, metadata, null);
		}

		private TraktSyncCollectionPostBuilder addMovieOrIgnore(TraktMovie movie, Date collectedAt) {
			return addMovieOrIgnore(movie, null, collectedAt);
		}

		private TraktSyncCollectionPostBuilder addMovieOrIgnore(TraktMovie movie) {
			return addMovieOrIgnore(movie, null, null);
		}

		private TraktSyncCollectionPostBuilder addShowOrIgnore(TraktShow show, TraktMetadata metadata, Date collectedAt) {
			if (containsShow(show)) return this;

			TraktSyncCollectionPostShowImpl collectionShow = new TraktSyncCollectionPostShowImpl();
			collectionShow.ids = show.getIds();
			collectionShow.title = show.getTitle();
			collectionShow.year = show.getYear();

			if (metadata != null) collectionShow.metadata = metadata;

			if (collectedAt != null) collectionShow.collectedAt = collectedAt;

			collectionPost.shows.add(collectionShow);

			return this;
		}

		private TraktSyncCollectionPostBuilder addShowOrIgnore(TraktShow show, TraktMetadata metadata) {
			return addShowOrIgnore(show, metadata, null);
		}

		private TraktSyncCollectionPostBuilder addShowOrIgnore(TraktShow show, Date collectedAt) {
			return addShowOrIgnore(show, null, collectedAt);
		}

		private TraktSyncCollectionPostBuilder addShowOrIgnore(TraktShow show) {
			return addShowOrIgnore(show, null, null);
		}

		private TraktSyncCollectionPostBuilder addEpisodeOrIgnore(TraktEpisode episode, TraktMetadata metadata, Date collectedAt) {
			if (containsEpisode(episode)) return this;

			TraktSyncCollectionPostEpisodeImpl collectionEpisode = new TraktSyncCollectionPostEpisodeImpl();
			collectionEpisode.ids = episode.getIds();

			if (metadata != null) collectionEpisode.metadata = metadata;

			if (collectedAt != null) collectionEpisode.collectedAt = collectedAt;

			collectionPost.episodes.add(collectionEpisode);

			return this;
		}

		private TraktSyncCollectionPostBuilder addEpisodeOrIgnore(TraktEpisode episode, TraktMetadata metadata) {
			return addEpisodeOrIgnore(episode, metadata, null);
		}

		private TraktSyncCollectionPostBuilder addEpisodeOrIgnore(TraktEpisode episode, Date collectedAt) {
			return addEpisodeOrIgnore(episode, null, collectedAt);
		}

		private TraktSyncCollectionPostBuilder addEpisodeOrIgnore(TraktEpisode episode) {
			return addEpisodeOrIgnore(episode, null, null);
		}

		//TODO Equality check
		private void createOrSetShow(TraktShow show, List<TraktSyncCollectionPostShowSeasonImpl> showSeasons, TraktMetadata metadata, Date collectedAt) {
			TraktSyncCollectionPostShowImpl existingShow = collectionPost.shows.stream().filter(s -> s.ids == show.getIds())
					.findFirst().orElseGet(TraktSyncCollectionPostShowImpl::new);

			if (existingShow != null) existingShow.seasons = showSeasons;
			else {
				TraktSyncCollectionPostShowImpl collectionShow = new TraktSyncCollectionPostShowImpl();
				collectionShow.ids = show.getIds();
				collectionShow.title = show.getTitle();
				collectionShow.year = show.getYear();

				if (metadata != null) collectionShow.metadata = metadata;

				if (collectedAt != null) collectionShow.collectedAt = collectedAt;

				collectionShow.seasons = showSeasons;

				collectionPost.shows.add(collectionShow);
			}
		}

		private void createOrSetShow(TraktShow show, List<TraktSyncCollectionPostShowSeasonImpl> showSeasons, TraktMetadata metadata) {
			createOrSetShow(show, showSeasons, metadata, null);
		}

		private void createOrSetShow(TraktShow show, List<TraktSyncCollectionPostShowSeasonImpl> showSeasons, Date collectedAt) {
			createOrSetShow(show, showSeasons, null, collectedAt);
		}

		private void createOrSetShow(TraktShow show, List<TraktSyncCollectionPostShowSeasonImpl> showSeasons) {
			createOrSetShow(show, showSeasons, null, null);
		}

		private List<TraktSyncCollectionPostShowSeasonImpl> createShowSeasons(int... seasons) {
			List<TraktSyncCollectionPostShowSeasonImpl> showSeasons = new ArrayList<>();

			for (int season : seasons) {
				if (season < 0) throw new IllegalArgumentException("at least one season number not valid");

				showSeasons.add(new TraktSyncCollectionPostShowSeasonImpl(season));
			}

			return showSeasons;
		}

		private List<TraktSyncCollectionPostShowSeasonImpl> createShowSeasons(PostSeasons seasons) {
			List<TraktSyncCollectionPostShowSeasonImpl> showSeasons = new ArrayList<>();

			for (PostSeasons.PostSeason season : seasons) {
				if (season.number < 0) throw new IllegalArgumentException("at least one season number not valid");

				TraktSyncCollectionPostShowSeasonImpl showSingleSeason = new TraktSyncCollectionPostShowSeasonImpl(season.number);

				if (season.episodes != null && season.episodes.size() > 0) {
					List<TraktSyncCollectionPostShowEpisodeImpl> showEpisodes = new ArrayList<>();

					for (int episode : season.episodes) {
						if (episode < 0) throw new IllegalArgumentException("at least one episode nubmer not valid");

						showEpisodes.add(new TraktSyncCollectionPostShowEpisodeImpl(episode));
					}

					showSingleSeason.episodes = showEpisodes;
				}

				showSeasons.add(showSingleSeason);
			}

			return showSeasons;
		}
	}
}
