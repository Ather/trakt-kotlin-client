package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktBoxOfficeMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;

public class TraktBoxOfficeMovieImpl implements TraktBoxOfficeMovie {
	private Long revenue;
	private TraktMovieImpl movie;

	@Override
	public Long getRevenue() {
		return revenue;
	}

	@Override
	public void setRevenue(Long revenue) {
		this.revenue = revenue;
	}

	@Override
	public TraktBoxOfficeMovieImpl withRevenue(Long revenue) {
		this.revenue = revenue;
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
	public TraktBoxOfficeMovieImpl withMovie(TraktMovieImpl movie) {
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
	public TraktBoxOfficeMovieImpl withTitle(String title) {
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
	public TraktBoxOfficeMovieImpl withYear(Integer year) {
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
	public TraktBoxOfficeMovieImpl withIds(TraktMovieIds ids) {
		if (movie != null) movie.withIds(ids);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktBoxOfficeMovieImpl that = (TraktBoxOfficeMovieImpl) o;

		return (revenue != null ? revenue.equals(that.revenue) : that.revenue == null) && (movie != null ? movie
				.equals(that.movie) : that.movie == null);
	}

	@Override
	public int hashCode() {
		int result = revenue != null ? revenue.hashCode() : 0;
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktBoxOfficeMovie{" + "revenue=" + revenue + ", movie=" + movie + '}';
	}
}
