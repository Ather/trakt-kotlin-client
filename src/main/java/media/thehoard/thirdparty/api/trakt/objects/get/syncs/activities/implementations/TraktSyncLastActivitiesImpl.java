package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.*;

import java.time.Instant;

public class TraktSyncLastActivitiesImpl implements TraktSyncLastActivities {
	private Instant all;
	private TraktSyncMoviesLastActivities movies;
	private TraktSyncEpisodesLastActivities episodes;
	private TraktSyncShowsLastActivities shows;
	private TraktSyncSeasonsLastActivities seasons;
	private TraktSyncCommentsLastActivities comments;
	private TraktSyncListsLastActivities lists;

	@Override
	public Instant getAll() {
		return all;
	}

	@Override
	public void setAll(Instant all) {
		this.all = all;
	}

	@Override
	public TraktSyncLastActivities withAll(Instant all) {
		this.all = all;
		return this;
	}

	@Override
	public TraktSyncMoviesLastActivities getMovies() {
		return movies;
	}

	@Override
	public void setMovies(TraktSyncMoviesLastActivities movies) {
		this.movies = movies;
	}

	@Override
	public TraktSyncLastActivities withMovies(TraktSyncMoviesLastActivities movies) {
		this.movies = movies;
		return this;
	}

	@Override
	public TraktSyncEpisodesLastActivities getEpisodes() {
		return episodes;
	}

	@Override
	public void setEpisodes(TraktSyncEpisodesLastActivities episodes) {
		this.episodes = episodes;
	}

	@Override
	public TraktSyncLastActivities withEpisodes(TraktSyncEpisodesLastActivities episodes) {
		this.episodes = episodes;
		return this;
	}

	@Override
	public TraktSyncShowsLastActivities getShows() {
		return shows;
	}

	@Override
	public void setShows(TraktSyncShowsLastActivities shows) {
		this.shows = shows;
	}

	@Override
	public TraktSyncLastActivities withShows(TraktSyncShowsLastActivities shows) {
		this.shows = shows;
		return this;
	}

	@Override
	public TraktSyncSeasonsLastActivities getSeasons() {
		return seasons;
	}

	@Override
	public void setSeasons(TraktSyncSeasonsLastActivities seasons) {
		this.seasons = seasons;
	}

	@Override
	public TraktSyncLastActivities withSeasons(TraktSyncSeasonsLastActivities seasons) {
		this.seasons = seasons;
		return this;
	}

	@Override
	public TraktSyncCommentsLastActivities getComments() {
		return comments;
	}

	@Override
	public void setComments(TraktSyncCommentsLastActivities comments) {
		this.comments = comments;
	}

	@Override
	public TraktSyncLastActivities withComments(TraktSyncCommentsLastActivities comments) {
		this.comments = comments;
		return this;
	}

	@Override
	public TraktSyncListsLastActivities getLists() {
		return lists;
	}

	@Override
	public void setLists(TraktSyncListsLastActivities lists) {
		this.lists = lists;
	}

	@Override
	public TraktSyncLastActivities withLists(TraktSyncListsLastActivities lists) {
		this.lists = lists;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSyncLastActivitiesImpl that = (TraktSyncLastActivitiesImpl) o;

		if (all != null ? !all.equals(that.all) : that.all != null) return false;
		if (movies != null ? !movies.equals(that.movies) : that.movies != null) return false;
		if (episodes != null ? !episodes.equals(that.episodes) : that.episodes != null) return false;
		if (shows != null ? !shows.equals(that.shows) : that.shows != null) return false;
		if (seasons != null ? !seasons.equals(that.seasons) : that.seasons != null) return false;
		if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
		return lists != null ? lists.equals(that.lists) : that.lists == null;
	}

	@Override
	public int hashCode() {
		int result = all != null ? all.hashCode() : 0;
		result = 31 * result + (movies != null ? movies.hashCode() : 0);
		result = 31 * result + (episodes != null ? episodes.hashCode() : 0);
		result = 31 * result + (shows != null ? shows.hashCode() : 0);
		result = 31 * result + (seasons != null ? seasons.hashCode() : 0);
		result = 31 * result + (comments != null ? comments.hashCode() : 0);
		result = 31 * result + (lists != null ? lists.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSyncLastActivities{" + "all=" + all + ", movies=" + movies + ", episodes=" + episodes + ", shows=" + shows + ", seasons=" + seasons + ", comments=" + comments + ", lists=" + lists + '}';
	}
}
