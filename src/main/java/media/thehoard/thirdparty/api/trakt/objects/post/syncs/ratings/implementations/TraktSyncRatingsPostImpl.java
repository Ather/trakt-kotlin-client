package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.post.PostRatingsEpisodes;
import media.thehoard.thirdparty.api.trakt.objects.post.PostRatingsSeasons;
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.AbstractTraktSyncPostBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TraktSyncRatingsPostImpl {
	private List<TraktSyncRatingsPostMovieImpl> movies;
	private List<TraktSyncRatingsPostShowImpl> shows;
	private List<TraktSyncRatingsPostEpisodeImpl> episodes;

	public static TraktSyncRatingsPostBuilder builder() {
		return new TraktSyncRatingsPostBuilder();
	}

	public final static class TraktSyncRatingsPostBuilder
			extends AbstractTraktSyncPostBuilder<TraktSyncRatingsPostImpl, TraktSyncRatingsPostBuilder> {
		private TraktSyncRatingsPostImpl ratingsPost;

		public TraktSyncRatingsPostBuilder() {
			this.ratingsPost = new TraktSyncRatingsPostImpl();
		}

		public TraktSyncRatingsPostBuilder addMovie(TraktMovie movie) {
			validateMovie(movie);
			ensureMoviesListExists();

			return addMovieOrIgnore(movie);
		}

		public TraktSyncRatingsPostBuilder addMovies(Collection<TraktMovie> movies) {
			if (movies == null) throw new IllegalArgumentException("movies");

			if (movies.size() == 0) return this;

			for (TraktMovie movie : movies)
				addMovie(movie);

			return this;
		}

		public TraktSyncRatingsPostBuilder addMovie(TraktMovie movie, int rating) {
			validateMovie(movie);
			validateRating(rating);
			ensureMoviesListExists();

			return addMovieOrIgnore(movie, rating);
		}

		public TraktSyncRatingsPostBuilder addMovie(TraktMovie movie, int rating, Date ratedAt) {
			validateMovie(movie);
			validateRating(rating);
			ensureMoviesListExists();

			return addMovieOrIgnore(movie, rating, ratedAt);
		}

		public TraktSyncRatingsPostBuilder addShow(TraktShow show) {
			validateShow(show);
			ensureShowsListExists();

			return addShowOrIgnore(show);
		}

		public TraktSyncRatingsPostBuilder addShows(Collection<TraktShow> shows) {
			if (shows == null) throw new IllegalArgumentException("shows");

			if (shows.size() == 0) return this;

			for (TraktShow show : shows)
				addShow(show);

			return this;
		}

		public TraktSyncRatingsPostBuilder addShow(TraktShow show, int... seasons) {
			validateShow(show);
			ensureShowsListExists();

			createOrSetShow(show, createShowSeasons(seasons));

			return this;
		}

		public TraktSyncRatingsPostBuilder addShow(TraktShow show, PostRatingsSeasons seasons) {
			validateShow(show);

			if (seasons == null) throw new IllegalArgumentException("seasons");

			ensureShowsListExists();

			createOrSetShow(show, createShowSeasons(seasons));

			return this;
		}

		public TraktSyncRatingsPostBuilder addShowWithRating(TraktShow show, int rating) {
			validateShow(show);
			validateRating(rating);
			ensureShowsListExists();

			return addShowOrIgnore(show, rating);
		}

		public TraktSyncRatingsPostBuilder addShowWithRating(TraktShow show, int rating, int... seasons) {
			validateShow(show);
			validateRating(rating);
			ensureShowsListExists();

			createOrSetShow(show, createShowSeasons(seasons), rating);

			return this;
		}

		public TraktSyncRatingsPostBuilder addShowWithRating(TraktShow show, int rating, PostRatingsSeasons seasons) {
			validateShow(show);
			validateRating(rating);

			if (seasons == null) throw new IllegalArgumentException("seasons");

			ensureShowsListExists();

			createOrSetShow(show, createShowSeasons(seasons), rating);

			return this;
		}

		public TraktSyncRatingsPostBuilder addShowWithRating(TraktShow show, int rating, Date ratedAt) {
			validateShow(show);
			validateRating(rating);
			ensureShowsListExists();

			return addShowOrIgnore(show, rating, ratedAt);
		}

		public TraktSyncRatingsPostBuilder addShowWithRating(TraktShow show, int rating, Date ratedAt, int... seasons) {
			validateShow(show);
			validateRating(rating);
			ensureShowsListExists();

			createOrSetShow(show, createShowSeasons(seasons), rating, ratedAt);

			return this;
		}

		public TraktSyncRatingsPostBuilder addShowWithRating(TraktShow show, int rating, Date ratedAt, PostRatingsSeasons seasons) {
			validateShow(show);
			validateRating(rating);

			if (seasons == null) throw new IllegalArgumentException("seasons");

			ensureShowsListExists();

			createOrSetShow(show, createShowSeasons(seasons), rating, ratedAt);

			return this;
		}

		public TraktSyncRatingsPostBuilder addEpisode(TraktEpisode episode) {
			validateEpisode(episode);
			ensureEpisodesListExists();

			return addEpisodeOrIgnore(episode);
		}

		public TraktSyncRatingsPostBuilder addEpisodes(Collection<TraktEpisode> episodes) {
			if (episodes == null) throw new IllegalArgumentException("episodes");

			if (episodes.size() == 0) return this;

			for (TraktEpisode episode : episodes)
				addEpisode(episode);

			return this;
		}

		public TraktSyncRatingsPostBuilder addEpisode(TraktEpisode episode, int rating) {
			validateEpisode(episode);
			validateRating(rating);
			ensureEpisodesListExists();

			return addEpisodeOrIgnore(episode, rating);
		}

		public TraktSyncRatingsPostBuilder addEpisode(TraktEpisode episode, int rating, Date ratedAt) {
			validateEpisode(episode);
			validateRating(rating);
			ensureEpisodesListExists();

			return addEpisodeOrIgnore(episode, rating, ratedAt);
		}

		@Override
		public void reset() {
			if (ratingsPost.movies != null) {
				ratingsPost.movies.clear();
				ratingsPost.movies = null;
			}

			if (ratingsPost.shows != null) {
				ratingsPost.shows.clear();
				ratingsPost.shows = null;
			}

			if (ratingsPost.episodes != null) {
				ratingsPost.episodes.clear();
				ratingsPost.episodes = null;
			}
		}

		@Override
		public TraktSyncRatingsPostImpl build() {
			return ratingsPost;
		}

		private void validateRating(int rating) {
			if (rating < 1 || rating > 10) throw new IllegalArgumentException("rating");
		}

		protected boolean containsMovie(TraktMovie movie) {
			for (TraktSyncRatingsPostMovieImpl m : ratingsPost.movies)
				if (m.getIds().equals(movie.getIds())) return true;

			return false;
		}

		protected boolean containsShow(TraktShow show) {
			for (TraktSyncRatingsPostShowImpl s : ratingsPost.shows)
				if (s.getIds().equals(show.getIds())) return true;

			return false;
		}

		protected boolean containsEpisode(TraktEpisode episode) {
			for (TraktSyncRatingsPostEpisodeImpl e : ratingsPost.episodes)
				if (e.getIds().equals(episode.getIds())) return true;

			return false;
		}

		@Override
		protected void ensureMoviesListExists() {
			if (ratingsPost.movies == null) ratingsPost.movies = new ArrayList<>();
		}

		@Override
		protected void ensureShowsListExists() {
			if (ratingsPost.shows == null) ratingsPost.shows = new ArrayList<>();
		}

		@Override
		protected void ensureEpisodesListExists() {
			if (ratingsPost.episodes == null) ratingsPost.episodes = new ArrayList<>();
		}

		private TraktSyncRatingsPostBuilder addMovieOrIgnore(TraktMovie movie, Integer rating, Date ratedAt) {
			if (containsMovie(movie)) return this;

			TraktSyncRatingsPostMovieImpl ratingsMovie = new TraktSyncRatingsPostMovieImpl();
			ratingsMovie.ids = movie.getIds();
			ratingsMovie.title = movie.getTitle();
			ratingsMovie.year = movie.getYear();

			if (rating != null) ratingsMovie.rating = rating;

			if (ratedAt != null) ratingsMovie.ratedAt = ratedAt;

			ratingsPost.movies.add(ratingsMovie);

			return this;
		}

		private TraktSyncRatingsPostBuilder addMovieOrIgnore(TraktMovie movie, Integer rating) {
			return addMovieOrIgnore(movie, rating, null);
		}

		private TraktSyncRatingsPostBuilder addMovieOrIgnore(TraktMovie movie, Date ratedAt) {
			return addMovieOrIgnore(movie, null, ratedAt);
		}

		private TraktSyncRatingsPostBuilder addMovieOrIgnore(TraktMovie movie) {
			return addMovieOrIgnore(movie, null, null);
		}

		private TraktSyncRatingsPostBuilder addShowOrIgnore(TraktShow show, Integer rating, Date ratedAt) {
			if (containsShow(show)) return this;

			TraktSyncRatingsPostShowImpl ratingsShow = new TraktSyncRatingsPostShowImpl();
			ratingsShow.ids = show.ids;
			ratingsShow.title = show.title;
			ratingsShow.year = show.year;

			if (rating != null) ratingsShow.rating = rating;

			if (ratedAt != null) ratingsShow.ratedAt = ratedAt;

			ratingsPost.shows.add(ratingsShow);

			return this;
		}

		private TraktSyncRatingsPostBuilder addShowOrIgnore(TraktShow show, Integer rating) {
			return addShowOrIgnore(show, rating, null);
		}

		private TraktSyncRatingsPostBuilder addShowOrIgnore(TraktShow show, Date ratedAt) {
			return addShowOrIgnore(show, null, ratedAt);
		}

		private TraktSyncRatingsPostBuilder addShowOrIgnore(TraktShow show) {
			return addShowOrIgnore(show, null, null);
		}

		private TraktSyncRatingsPostBuilder addEpisodeOrIgnore(TraktEpisode episode, Integer rating, Date ratedAt) {
			if (containsEpisode(episode)) return this;

			TraktSyncRatingsPostEpisodeImpl ratingsEpisode = new TraktSyncRatingsPostEpisodeImpl();
			ratingsEpisode.ids = episode.ids;

			if (rating != null) ratingsEpisode.rating = rating;

			if (ratedAt != null) ratingsEpisode.ratedAt = ratedAt;

			ratingsPost.episodes.add(ratingsEpisode);

			return this;
		}

		private TraktSyncRatingsPostBuilder addEpisodeOrIgnore(TraktEpisode episode, Integer rating) {
			return addEpisodeOrIgnore(episode, rating, null);
		}

		private TraktSyncRatingsPostBuilder addEpisodeOrIgnore(TraktEpisode episode, Date ratedAt) {
			return addEpisodeOrIgnore(episode, null, ratedAt);
		}

		private TraktSyncRatingsPostBuilder addEpisodeOrIgnore(TraktEpisode episode) {
			return addEpisodeOrIgnore(episode, null, null);
		}

		private void createOrSetShow(TraktShow show, List<TraktSyncRatingsPostShowSeasonImpl> showSeasons, Integer rating, Date ratedAt) {
			TraktSyncRatingsPostShowImpl existingShow = ratingsPost.shows.stream().filter(s -> s.ids == show.ids)
					.findFirst().orElseGet(TraktSyncRatingsPostShowImpl::new);

			if (existingShow != null) existingShow.seasons = showSeasons;
			else {
				TraktSyncRatingsPostShowImpl ratingsShow = new TraktSyncRatingsPostShowImpl();
				ratingsShow.ids = show.ids;
				ratingsShow.title = show.title;
				ratingsShow.year = show.year;

				if (ratedAt != null) ratingsShow.ratedAt = ratedAt;

				ratingsShow.seasons = showSeasons;

				ratingsPost.shows.add(ratingsShow);
			}
		}

		private void createOrSetShow(TraktShow show, List<TraktSyncRatingsPostShowSeasonImpl> seasons, Integer rating) {
			createOrSetShow(show, seasons, rating, null);
		}

		private void createOrSetShow(TraktShow show, List<TraktSyncRatingsPostShowSeasonImpl> seasons, Date ratedAt) {
			createOrSetShow(show, seasons, null, ratedAt);
		}

		private void createOrSetShow(TraktShow show, List<TraktSyncRatingsPostShowSeasonImpl> seasons) {
			createOrSetShow(show, seasons, null, null);
		}

		private List<TraktSyncRatingsPostShowSeasonImpl> createShowSeasons(int... seasons) {
			if (seasons == null) throw new IllegalArgumentException("seasons");

			List<TraktSyncRatingsPostShowSeasonImpl> showSeasons = new ArrayList<>();

			for (int season : seasons) {
				if (season < 0) throw new IllegalArgumentException("at least one season number not valid");

				showSeasons.add(new TraktSyncRatingsPostShowSeasonImpl(season));
			}

			return showSeasons;
		}

		private List<TraktSyncRatingsPostShowSeasonImpl> createShowSeasons(PostRatingsSeasons seasons) {
			List<TraktSyncRatingsPostShowSeasonImpl> showSeasons = new ArrayList<>();

			for (PostRatingsSeasons.PostRatingsSeason season : seasons) {
				if (season.number < 0) throw new IllegalArgumentException("at least one season number not valid");

				TraktSyncRatingsPostShowSeasonImpl showSingleSeason = new TraktSyncRatingsPostShowSeasonImpl(season.number);

				if (season.rating != null) showSingleSeason.rating = season.rating;

				if (season.ratedAt != null) showSingleSeason.ratedAt = season.ratedAt;

				if (season.episodes != null && season.episodes.size() > 0) {
					List<TraktSyncRatingsPostShowEpisodeImpl> showEpisodes = new ArrayList<>();

					for (PostRatingsEpisodes.PostRatingsEpisode episode : season.episodes) {
						if (episode.number < 0)
							throw new IllegalArgumentException("at least one episode number not valid");

						TraktSyncRatingsPostShowEpisodeImpl showEpisode = new TraktSyncRatingsPostShowEpisodeImpl(episode.number);

						if (episode.rating != null) showEpisode.rating = episode.rating;

						if (episode.ratedAt != null) showEpisode.ratedAt = episode.ratedAt;

						showEpisodes.add(showEpisode);
					}

					showSingleSeason.episodes = showEpisodes;
				}

				showSeasons.add(showSingleSeason);
			}

			return showSeasons;
		}

		@Override
		protected TraktSyncRatingsPostBuilder self() {
			return this;
		}
	}
}
