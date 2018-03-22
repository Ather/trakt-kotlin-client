package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;

import java.util.ArrayList;
import java.util.List;

public class TraktSyncHistoryRemovePostImpl {
	private List<TraktSyncHistoryPostMovieImpl> movies;
	private List<TraktSyncHistoryPostShowImpl> shows;
	private List<TraktSyncHistoryPostEpisodeImpl> episodes;
	private List<Long> ids;

	public static TraktSyncHistoryRemovePostBuilder builder() {
		return new TraktSyncHistoryRemovePostBuilder();
	}

	//TODO
	public final static class TraktSyncHistoryRemovePostBuilder
			extends AbstractTraktSyncHistoryPostBuilder<TraktSyncHistoryRemovePostImpl, TraktSyncHistoryRemovePostBuilder> {
		private TraktSyncHistoryRemovePostImpl historyPost;

		public TraktSyncHistoryRemovePostBuilder() {
			this.historyPost = new TraktSyncHistoryRemovePostImpl();
		}

		public TraktSyncHistoryRemovePostBuilder addHistoryIds(long... ids) {
			for (long id : ids) {
				if (id == 0)
					throw new IllegalArgumentException("at least one history id is not valid");

				historyPost.ids.add(id);
			}

			return this;
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

		public TraktSyncHistoryRemovePostImpl build() {
			return historyPost;
		}

		//TODO Consider the equality test used in these methods.
		protected boolean containsMovie(TraktMovie movie) {
			for (TraktSyncHistoryPostMovieImpl m : historyPost.movies)
				if (m.getIds().equals(movie.getIds()))
					return true;

			return false;
		}

		protected boolean containsShow(TraktShow show) {
			for (TraktSyncHistoryPostShowImpl s : historyPost.shows)
				if (s.getIds().equals(show.getIds()))
					return true;

			return false;
		}

		protected void ensureMoviesListExists() {
			if (historyPost.movies == null)
				historyPost.movies = new ArrayList<>();
		}

		protected void ensureShowsListExists() {
			if (historyPost.shows == null)
				historyPost.shows = new ArrayList<>();
		}

		protected boolean containsEpisode(TraktEpisode episode) {
			for (TraktSyncHistoryPostEpisodeImpl e : historyPost.episodes)
				if (e.getIds().equals(episode.getIds()))
					return true;

			return false;
		}

		protected void ensureEpisodesListExists() {
			if (historyPost.episodes == null)
				historyPost.episodes = new ArrayList<>();
		}

		protected TraktSyncHistoryRemovePostBuilder addMovieOrIgnore(TraktMovie movie) {
			if (containsMovie(movie))
				return this;

			TraktSyncHistoryPostMovieImpl historyMovie = new TraktSyncHistoryPostMovieImpl();
			historyMovie.setIds(movie.getIds());
			historyMovie.setTitle(movie.getTitle());
			historyMovie.setYear(movie.getYear());

			historyPost.movies.add(historyMovie);

			return this;
		}

		protected TraktSyncHistoryRemovePostBuilder addShowOrIgnore(TraktShow show) {
			if (containsShow(show))
				return this;

			TraktSyncHistoryPostShowImpl historyShow = new TraktSyncHistoryPostShowImpl();
			historyShow.setIds(show.getIds());
			historyShow.setTitle(show.getTitle());
			historyShow.setYear(show.getYear());

			historyPost.shows.add(historyShow);

			return this;
		}

		protected TraktSyncHistoryRemovePostBuilder addEpisodeOrIgnore(TraktEpisode episode) {
			if (containsEpisode(episode))
				return this;

			TraktSyncHistoryPostEpisodeImpl historyEpisode = new TraktSyncHistoryPostEpisodeImpl();
			historyEpisode.setIds(episode.getIds());

			historyPost.episodes.add(historyEpisode);

			return this;
		}

		//TODO Equality check
		protected void createOrSetShow(TraktShow show, List<TraktSyncHistoryPostShowSeasonImpl> showSeasons) {
			TraktSyncHistoryPostShowImpl existingShow = historyPost.shows.stream().filter(s -> s.getIds().equals(show.getIds()))
					.findFirst().orElseGet(TraktSyncHistoryPostShowImpl::new);

			if (existingShow != null)
				existingShow.setSeasons(showSeasons);
			else {
				TraktSyncHistoryPostShowImpl historyShow = new TraktSyncHistoryPostShowImpl();
				historyShow.setIds(show.getIds());
				historyShow.setTitle(show.getTitle());
				historyShow.setYear(show.getYear());

				historyShow.setSeasons(showSeasons);

				historyPost.shows.add(historyShow);
			}
		}

		@Override
		protected TraktSyncHistoryRemovePostBuilder self() {
			return this;
		}
	}
}
