package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.PostSeasons;
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.AbstractTraktSyncPostBuilder;
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TraktUserCustomListItemsPostImpl {
	private List<TraktUserCustomListItemsPostMovieImpl> movies;
	private List<TraktUserCustomListItemsPostShowImpl> shows;
	private List<TraktPersonImpl> people;

	public static TraktUserCustomListItemsPostBuilder builder() {
		return new TraktUserCustomListItemsPostBuilder();
	}

	public static final class TraktUserCustomListItemsPostBuilder extends AbstractTraktSyncPostBuilder<TraktUserCustomListItemsPostImpl, TraktUserCustomListItemsPostBuilder> {
		private TraktUserCustomListItemsPostImpl listItemsPost;

		public TraktUserCustomListItemsPostBuilder() {
			this.listItemsPost = new TraktUserCustomListItemsPostImpl();
		}

		public TraktUserCustomListItemsPostBuilder addMovie(TraktMovieImpl movie) {
			if (movie == null)
				throw new IllegalArgumentException("movie");

			if (movie.ids == null)
				throw new IllegalArgumentException("movie ids");

			if (!movie.ids.hasAnyId())
				throw new IllegalArgumentException("no movie ids set or valid");

			if (movie.year != null && movie.year.toString().length() != 4)
				throw new IllegalArgumentException("movie year not valid");

			ensureMoviesListExists();

			TraktUserCustomListItemsPostMovieImpl existingMovie = listItemsPost.movies.stream().filter(m -> m.ids == movie.ids)
					.findFirst().orElseGet(null);

			if (existingMovie != null)
				return this;

			listItemsPost.movies.add(new TraktUserCustomListItemsPostMovieImpl(movie.ids));

			return this;
		}

		public TraktUserCustomListItemsPostBuilder addMovies(Collection<TraktMovieImpl> movies) {
			if (movies == null)
				throw new IllegalArgumentException("movies");

			if (movies.size() == 0)
				return this;

			for (TraktMovieImpl movie : movies)
				addMovie(movie);

			return this;
		}

		public TraktUserCustomListItemsPostBuilder addShow(TraktShowImpl show) {
			validateShow(show);
			ensureShowsListExists();

			TraktUserCustomListItemsPostShowImpl existingShow = listItemsPost.shows.stream().filter(s -> s.ids == show.ids)
					.findFirst().orElse(null);

			if (existingShow != null)
				return this;

			listItemsPost.shows.add(new TraktUserCustomListItemsPostShowImpl(show.ids));

			return this;
		}

		public TraktUserCustomListItemsPostBuilder addShows(Collection<TraktShow> shows) {
			if (shows == null)
				throw new IllegalArgumentException("shows");

			if (shows.size() == 0)
				return this;

			for (TraktShowImpl show : shows)
				addShow(show);

			return this;
		}

		public TraktUserCustomListItemsPostBuilder addShow(TraktShowImpl show, int... seasons) {
			validateShow(show);
			ensureShowsListExists();

			if (seasons == null)
				throw new IllegalArgumentException("seasons");

			List<TraktUserCustomListItemsPostShowSeasonImpl> showSeasons = new ArrayList<>();

			for (int season : seasons) {
				if (season < 0)
					throw new IllegalArgumentException("at least one season number not valid");

				showSeasons.add(new TraktUserCustomListItemsPostShowSeasonImpl(season));
			}

			TraktUserCustomListItemsPostShowImpl existingShow = listItemsPost.shows.stream().filter(s -> s.ids == show.ids)
					.findFirst().orElse(null);

			if (existingShow != null)
				existingShow.seasons = showSeasons;
			else {
				TraktUserCustomListItemsPostShowImpl listItemsShow = new TraktUserCustomListItemsPostShowImpl();
				listItemsShow.ids = show.ids;

				listItemsShow.seasons = showSeasons;

				listItemsPost.shows.add(listItemsShow);
			}

			return this;
		}

		public TraktUserCustomListItemsPostBuilder addShow(TraktShowImpl show, PostSeasons seasons) {
			validateShow(show);
			ensureShowsListExists();

			if (listItemsPost.shows == null)
				listItemsPost.shows = new ArrayList<>();

			List<TraktUserCustomListItemsPostShowSeasonImpl> showSeasons = null;

			if (seasons.size() > 0) {
				showSeasons = new ArrayList<>();

				for (PostSeasons.PostSeason season : seasons) {
					if (season.number < 0)
						throw new IllegalArgumentException("at least one season number not valid");

					TraktUserCustomListItemsPostShowSeasonImpl showSingleSeason = new TraktUserCustomListItemsPostShowSeasonImpl(season.number);

					if (season.episodes != null && season.episodes.size() > 0) {
						List<TraktUserCustomListItemsPostShowEpisodeImpl> showEpisodes = new ArrayList<>();

						for (int episode : season.episodes) {
							if (episode < 0)
								throw new IllegalArgumentException("at least one episode number not valid");

							showEpisodes.add(new TraktUserCustomListItemsPostShowEpisodeImpl(episode));
						}

						showSingleSeason.episodes = showEpisodes;
					}

					showSeasons.add(showSingleSeason);
				}
			}

			TraktUserCustomListItemsPostShowImpl existingShow = listItemsPost.shows.stream().filter(s -> s.ids == show.ids)
					.findFirst().orElse(null);

			if (existingShow != null)
				existingShow.seasons = showSeasons;
			else {
				TraktUserCustomListItemsPostShowImpl listItemsShow = new TraktUserCustomListItemsPostShowImpl();
				listItemsShow.ids = show.ids;

				listItemsShow.seasons = showSeasons;

				listItemsPost.shows.add(listItemsShow);
			}

			return this;
		}

		public TraktUserCustomListItemsPostBuilder addPerson(TraktPersonImpl person) {
			if (person == null)
				throw new IllegalArgumentException("person");

			if (person.ids == null)
				throw new IllegalArgumentException("person ids");

			if (!person.ids.hasAnyId())
				throw new IllegalArgumentException("no person ids set or valid");

			if (TraktUtils.isNullOrEmpty(person.name))
				throw new IllegalArgumentException("person name not valid");

			ensurePersonsListExists();

			TraktPersonImpl existingPerson = listItemsPost.people.stream().filter(m -> m.ids == person.ids)
					.findFirst().orElseGet(null);

			if (existingPerson != null)
				return this;

			listItemsPost.people.add(person);

			return this;
		}

		public TraktUserCustomListItemsPostBuilder addPersons(Collection<TraktPersonImpl> persons) {
			if (persons == null)
				throw new IllegalArgumentException("persons");

			if (persons.size() == 0)
				return this;

			for (TraktPersonImpl person : persons)
				addPerson(person);

			return this;
		}

		@Override
		public void reset() {
			if (listItemsPost.movies != null) {
				listItemsPost.movies.clear();
				listItemsPost.movies = null;
			}

			if (listItemsPost.shows != null) {
				listItemsPost.shows.clear();
				listItemsPost.shows = null;
			}

			if (listItemsPost.people != null) {
				listItemsPost.people.clear();
				listItemsPost.people = null;
			}
		}

		@Override
		public TraktUserCustomListItemsPostImpl build() {
			return listItemsPost;
		}

		@Override
		protected void ensureMoviesListExists() {
			if (listItemsPost.movies == null)
				listItemsPost.movies = new ArrayList<>();
		}

		@Override
		protected void ensureShowsListExists() {
			if (listItemsPost.shows == null)
				listItemsPost.shows = new ArrayList<>();
		}

		@Override
		protected void ensureEpisodesListExists() {}

		protected void ensurePersonsListExists() {
			if (listItemsPost.people == null)
				listItemsPost.people = new ArrayList<>();
		}

		@Override
		protected TraktUserCustomListItemsPostBuilder self() {
			return this;
		}
	}
}
