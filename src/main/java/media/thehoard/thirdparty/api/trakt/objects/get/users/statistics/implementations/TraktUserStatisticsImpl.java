package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.TraktUserStatistics;

public class TraktUserStatisticsImpl
		implements media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.TraktUserStatistics {
	private TraktUserMoviesStatisticsImpl movies;
	private TraktUserShowsStatisticsImpl shows;
	private TraktUserSeasonsStatisticsImpl seasons;
	private TraktUserEpisodesStatisticsImpl episodes;
	private TraktUserNetworkStatisticsImpl network;
	private TraktUserRatingsStatisticsImpl ratings;

	@Override
	public TraktUserMoviesStatisticsImpl getMovies() {
		return movies;
	}

	@Override
	public void setMovies(TraktUserMoviesStatisticsImpl movies) {
		this.movies = movies;
	}

	@Override
	public TraktUserStatistics withMovies(TraktUserMoviesStatisticsImpl movies) {
		this.movies = movies;
		return this;
	}

	@Override
	public TraktUserShowsStatisticsImpl getShows() {
		return shows;
	}

	@Override
	public void setShows(TraktUserShowsStatisticsImpl shows) {
		this.shows = shows;
	}

	@Override
	public TraktUserStatistics withShows(TraktUserShowsStatisticsImpl shows) {
		this.shows = shows;
		return this;
	}

	@Override
	public TraktUserSeasonsStatisticsImpl getSeasons() {
		return seasons;
	}

	@Override
	public void setSeasons(TraktUserSeasonsStatisticsImpl seasons) {
		this.seasons = seasons;
	}

	@Override
	public TraktUserStatistics withSeasons(TraktUserSeasonsStatisticsImpl seasons) {
		this.seasons = seasons;
		return this;
	}

	@Override
	public TraktUserEpisodesStatisticsImpl getEpisodes() {
		return episodes;
	}

	@Override
	public void setEpisodes(TraktUserEpisodesStatisticsImpl episodes) {
		this.episodes = episodes;
	}

	@Override
	public TraktUserStatistics withEpisodes(TraktUserEpisodesStatisticsImpl episodes) {
		this.episodes = episodes;
		return this;
	}

	@Override
	public TraktUserNetworkStatisticsImpl getNetwork() {
		return network;
	}

	@Override
	public void setNetwork(TraktUserNetworkStatisticsImpl network) {
		this.network = network;
	}

	@Override
	public TraktUserStatistics withNetwork(TraktUserNetworkStatisticsImpl network) {
		this.network = network;
		return this;
	}

	@Override
	public TraktUserRatingsStatisticsImpl getRatings() {
		return ratings;
	}

	@Override
	public void setRatings(TraktUserRatingsStatisticsImpl ratings) {
		this.ratings = ratings;
	}

	@Override
	public TraktUserStatistics withRatings(TraktUserRatingsStatisticsImpl ratings) {
		this.ratings = ratings;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserStatisticsImpl that = (TraktUserStatisticsImpl) o;

		if (movies != null ? !movies.equals(that.movies) : that.movies != null) return false;
		if (shows != null ? !shows.equals(that.shows) : that.shows != null) return false;
		if (seasons != null ? !seasons.equals(that.seasons) : that.seasons != null) return false;
		if (episodes != null ? !episodes.equals(that.episodes) : that.episodes != null) return false;
		if (network != null ? !network.equals(that.network) : that.network != null) return false;
		return ratings != null ? ratings.equals(that.ratings) : that.ratings == null;
	}

	@Override
	public int hashCode() {
		int result = movies != null ? movies.hashCode() : 0;
		result = 31 * result + (shows != null ? shows.hashCode() : 0);
		result = 31 * result + (seasons != null ? seasons.hashCode() : 0);
		result = 31 * result + (episodes != null ? episodes.hashCode() : 0);
		result = 31 * result + (network != null ? network.hashCode() : 0);
		result = 31 * result + (ratings != null ? ratings.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserStatistics{" + "movies=" + movies + ", shows=" + shows + ", seasons=" + seasons + ", episodes=" + episodes + ", network=" + network + ", ratings=" + ratings + '}';
	}
}
