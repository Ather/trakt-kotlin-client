package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktMetadata;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.post.PostHistorySeasons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TraktSyncHistoryPostImpl {
	public List<TraktSyncHistoryPostMovieImpl> movies;

	public List<TraktSyncHistoryPostShowImpl> shows;

	public List<TraktSyncHistoryPostEpisodeImpl> episodes;

	public static TraktSyncHistoryPostBuilder builder() {
		return new TraktSyncHistoryPostBuilder();
	}

	public final static class TraktSyncHistoryPostBuilder
			extends AbstractTraktSyncHistoryPostBuilder<TraktSyncHistoryPostImpl, TraktSyncHistoryPostBuilder> {
		private TraktSyncHistoryPostImpl historyPost;

		public TraktSyncHistoryPostBuilder() {
			this.historyPost = new TraktSyncHistoryPostImpl();
		}

		public TraktSyncHistoryPostBuilder addMovie(TraktMovie movie, Date watchedAt) {
			validateMovie(movie);
			ensureMoviesListExists();

			return addMovieOrIgnore(movie, null, watchedAt);
		}

		public TraktSyncHistoryPostBuilder addMovie(TraktMovie movie, TraktMetadata metadata) {
			validateMovie(movie);
			ensureMoviesListExists();

			return addMovieOrIgnore(movie, metadata);
		}

		public TraktSyncHistoryPostBuilder addMovie(TraktMovie movie, TraktMetadata metadata, Date watchedAt) {
			validateMovie(movie);
			ensureMoviesListExists();

			return addMovieOrIgnore(movie, metadata, watchedAt);
		}

		public TraktSyncHistoryPostBuilder addShow(TraktShow show, Date watchedAt) {
			validateShow(show);
			ensureShowsListExists();

			return addShowOrIgnore(show, null, watchedAt);
		}

		public TraktSyncHistoryPostBuilder addShow(TraktShow show, TraktMetadata metadata) {
			validateShow(show);
			ensureShowsListExists();

			return addShowOrIgnore(show, metadata);
		}

		public TraktSyncHistoryPostBuilder addShow(TraktShow show, TraktMetadata metadata, Date watchedAt) {
			validateShow(show);
			ensureShowsListExists();

			return addShowOrIgnore(show, metadata, watchedAt);
		}

		public TraktSyncHistoryPostBuilder addShow(TraktShow show, Date watchedAt, int... seasons) {
			validateShow(show);
			ensureShowsListExists();

			List<TraktSyncHistoryPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons, null, watchedAt);

			return this;
		}

		public TraktSyncHistoryPostBuilder addShow(TraktShow show, TraktMetadata metadata, int... seasons) {
			validateShow(show);
			ensureShowsListExists();

			List<TraktSyncHistoryPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons, metadata);

			return this;
		}

		public TraktSyncHistoryPostBuilder addShow(TraktShow show, TraktMetadata metadata, Date watchedAt, int... seasons) {
			validateShow(show);
			ensureShowsListExists();

			List<TraktSyncHistoryPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons, metadata, watchedAt);

			return this;
		}

		public TraktSyncHistoryPostBuilder addShow(TraktShow show, Date watchedAt, PostHistorySeasons seasons) {
			validateShow(show);

			if (seasons == null)
				throw new IllegalArgumentException("seasons");

			ensureShowsListExists();

			List<TraktSyncHistoryPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons, null, watchedAt);

			return this;
		}

		public TraktSyncHistoryPostBuilder addShow(TraktShow show, TraktMetadata metadata, PostHistorySeasons seasons) {
			validateShow(show);

			if (seasons == null)
				throw new IllegalArgumentException("seasons");

			ensureShowsListExists();

			List<TraktSyncHistoryPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons, metadata);

			return this;
		}

		public TraktSyncHistoryPostBuilder addShow(TraktShow show, TraktMetadata metadata, Date watchedAt, PostHistorySeasons seasons) {
			validateShow(show);

			if (seasons == null)
				throw new IllegalArgumentException("seasons");

			ensureShowsListExists();

			List<TraktSyncHistoryPostShowSeasonImpl> showSeasons = createShowSeasons(seasons);
			createOrSetShow(show, showSeasons, metadata, watchedAt);

			return this;
		}

		public TraktSyncHistoryPostBuilder addEpisode(TraktEpisode episode, Date watchedAt) {
			validateEpisode(episode);
			ensureEpisodesListExists();

			return addEpisodeOrIgnore(episode, null, watchedAt);
		}

		public TraktSyncHistoryPostBuilder addEpisode(TraktEpisode episode, TraktMetadata metadata) {
			validateEpisode(episode);
			ensureEpisodesListExists();

			return addEpisodeOrIgnore(episode, metadata);
		}

		public TraktSyncHistoryPostBuilder addEpisode(TraktEpisode episode, TraktMetadata metadata, Date watchedAt) {
			validateEpisode(episode);
			ensureEpisodesListExists();

			return addEpisodeOrIgnore(episode, metadata, watchedAt);
		}

		public void reset() {
			if (historyPost.movies != null) {
				historyPost.movies.clear();
				historyPost.movies = null;
			}

			if (historyPost.shows != null) {
				historyPost.shows.clear();
				historyPost.shows = null;
			}

			if (historyPost.episodes != null) {
				historyPost.episodes.clear();
				historyPost.episodes = null;
			}
		}

		public TraktSyncHistoryPostImpl build() {
			return historyPost;
		}

		//TODO Consider the equality test used in these methods.
		protected boolean containsMovie(TraktMovie movie) {
			for (TraktSyncHistoryPostMovieImpl m : historyPost.movies)
				if (m.ids.equals(movie.getIds()))
					return true;

			return false;
		}

		protected void ensureMoviesListExists() {
			if (historyPost.movies == null)
				historyPost.movies = new ArrayList<>();
		}

		protected boolean containsShow(TraktShow show) {
			for (TraktSyncHistoryPostShowImpl s : historyPost.shows)
				if (s.ids.equals(show.getIds()))
					return true;

			return false;
		}

		protected void ensureShowsListExists() {
			if (historyPost.shows == null)
				historyPost.shows = new ArrayList<>();
		}

		protected boolean containsEpisode(TraktEpisode episode) {
			for (TraktSyncHistoryPostEpisodeImpl e : historyPost.episodes)
				if (e.ids.equals(episode.getIds()))
					return true;

			return false;
		}

		protected void ensureEpisodesListExists() {
			if (historyPost.episodes == null)
				historyPost.episodes = new ArrayList<>();
		}

		private TraktSyncHistoryPostBuilder addMovieOrIgnore(TraktMovie movie, TraktMetadata metadata, Date watchedAt) {
			if (containsMovie(movie))
				return this;

			TraktSyncHistoryPostMovieImpl historyMovie = new TraktSyncHistoryPostMovieImpl();
			historyMovie.ids = movie.getIds();
			historyMovie.title = movie.getTitle();
			historyMovie.year = movie.getYear();

			if (watchedAt != null)
				historyMovie.watchedAt = watchedAt;

			historyPost.movies.add(historyMovie);

			return this;
		}

		private TraktSyncHistoryPostBuilder addMovieOrIgnore(TraktMovie movie, TraktMetadata metadata) {
			return addMovieOrIgnore(movie, metadata, null);
		}

		private TraktSyncHistoryPostBuilder addMovieOrIgnore(TraktMovie movie, Date watchedAt) {
			return addMovieOrIgnore(movie, null, watchedAt);
		}

		@Override
		protected TraktSyncHistoryPostBuilder addMovieOrIgnore(TraktMovie movie) {
			return addMovieOrIgnore(movie, null, null);
		}

		private TraktSyncHistoryPostBuilder addShowOrIgnore(TraktShow show, TraktMetadata metadata, Date watchedAt) {
			if (containsShow(show))
				return this;

			TraktSyncHistoryPostShowImpl historyShow = new TraktSyncHistoryPostShowImpl();
			historyShow.ids = show.getIds();
			historyShow.title = show.getTitle();
			historyShow.year = show.getYear();

			if (watchedAt != null)
				historyShow.watchedAt = watchedAt;

			historyPost.shows.add(historyShow);

			return this;
		}

		private TraktSyncHistoryPostBuilder addShowOrIgnore(TraktShow show, TraktMetadata metadata) {
			return addShowOrIgnore(show, metadata, null);
		}

		private TraktSyncHistoryPostBuilder addShowOrIgnore(TraktShow show, Date watchedAt) {
			return addShowOrIgnore(show, null, watchedAt);
		}

		@Override
		protected TraktSyncHistoryPostBuilder addShowOrIgnore(TraktShow show) {
			return addShowOrIgnore(show, null, null);
		}

		private TraktSyncHistoryPostBuilder addEpisodeOrIgnore(TraktEpisode episode, TraktMetadata metadata, Date watchedAt) {
			if (containsEpisode(episode))
				return this;

			TraktSyncHistoryPostEpisodeImpl historyEpisode = new TraktSyncHistoryPostEpisodeImpl();
			historyEpisode.ids = episode.getIds();

			if (watchedAt != null)
				historyEpisode.watchedAt = watchedAt;

			historyPost.episodes.add(historyEpisode);

			return this;
		}

		private TraktSyncHistoryPostBuilder addEpisodeOrIgnore(TraktEpisode episode, TraktMetadata metadata) {
			return addEpisodeOrIgnore(episode, metadata, null);
		}

		private TraktSyncHistoryPostBuilder addEpisodeOrIgnore(TraktEpisode episode, Date watchedAt) {
			return addEpisodeOrIgnore(episode, null, watchedAt);
		}

		@Override
		protected TraktSyncHistoryPostBuilder addEpisodeOrIgnore(TraktEpisode episode) {
			return addEpisodeOrIgnore(episode, null, null);
		}

		//TODO Equality check
		private void createOrSetShow(TraktShow show, List<TraktSyncHistoryPostShowSeasonImpl> showSeasons, TraktMetadata metadata, Date watchedAt) {
			TraktSyncHistoryPostShowImpl existingShow = historyPost.shows.stream().filter(s -> s.ids.equals(show.getIds()))
					.findFirst().orElseGet(TraktSyncHistoryPostShowImpl::new);

			if (existingShow != null)
				existingShow.seasons = showSeasons;
			else {
				TraktSyncHistoryPostShowImpl historyShow = new TraktSyncHistoryPostShowImpl();
				historyShow.ids = show.getIds();
				historyShow.title = show.getTitle();
				historyShow.year = show.getYear();

				if (watchedAt != null)
					historyShow.watchedAt = watchedAt;

				historyShow.seasons = showSeasons;

				historyPost.shows.add(historyShow);
			}
		}

		private void createOrSetShow(TraktShow show, List<TraktSyncHistoryPostShowSeasonImpl> showSeasons, TraktMetadata metadata) {
			createOrSetShow(show, showSeasons, metadata, null);
		}

		private void createOrSetShow(TraktShow show, List<TraktSyncHistoryPostShowSeasonImpl> showSeasons, Date watchedAt) {
			createOrSetShow(show, showSeasons, null, watchedAt);
		}

		@Override
		protected void createOrSetShow(TraktShow show, List<TraktSyncHistoryPostShowSeasonImpl> showSeasons) {
			createOrSetShow(show, showSeasons, null, null);
		}

		@Override
		protected TraktSyncHistoryPostBuilder self() {
			return this;
		}
	}
}
