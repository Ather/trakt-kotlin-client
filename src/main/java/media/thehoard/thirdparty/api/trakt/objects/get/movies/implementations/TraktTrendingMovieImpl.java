package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktTrendingMovie;

public class TraktTrendingMovieImpl implements TraktTrendingMovie {
	private Integer watchers;
	private TraktMovieImpl movie;

	@Override
	public Integer getWatchers() {
		return watchers;
	}

	@Override
	public void setWatchers(Integer watchers) {
		this.watchers = watchers;
	}

	@Override
	public TraktTrendingMovie withWatchers(Integer watchers) {
		this.watchers = watchers;
		return this;
	}

	@Override
	public TraktMovieImpl getMovie() {
		return movie;
	}

	@Override
	public void setMovie(TraktMovieImpl movie) {
		this.movie = movie;
	}

	@Override
	public TraktTrendingMovie withMovie(TraktMovieImpl movie) {
		this.movie = movie;
		return this;
	}

	@Override
	public String getTitle() {
		return movie != null ? movie.getTitle() : null;
	}

	@Override
	public void setTitle(String title) {
		if (movie != null) movie.setTitle(title);
	}

	@Override
	public TraktTrendingMovieImpl withTitle(String title) {
		if (movie != null) movie.setTitle(title);
		return this;
	}

	@Override
	public Integer getYear() {
		return movie != null ? movie.getYear() : null;
	}

	@Override
	public void setYear(Integer year) {
		if (movie != null) movie.setYear(year);
	}

	@Override
	public TraktTrendingMovieImpl withYear(Integer year) {
		if (movie != null) movie.withYear(year);
		return this;
	}

	@Override
	public TraktMovieIds getIds() {
		return movie != null ? movie.getIds() : null;
	}

	@Override
	public void setIds(TraktMovieIds ids) {
		if (movie != null) movie.setIds(ids);
	}

	@Override
	public TraktTrendingMovieImpl withIds(TraktMovieIds ids) {
		if (movie != null) movie.withIds(ids);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktTrendingMovieImpl that = (TraktTrendingMovieImpl) o;

		return (watchers != null ? watchers.equals(that.watchers) : that.watchers == null) && (movie != null ? movie
				.equals(that.movie) : that.movie == null);
	}

	@Override
	public int hashCode() {
		int result = watchers != null ? watchers.hashCode() : 0;
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktTrendingMovie{" + "watchers=" + watchers + ", movie=" + movie + '}';
	}
}
