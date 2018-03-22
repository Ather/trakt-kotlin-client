package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktRecentlyUpdatedMovie;

import java.util.Date;

public class TraktRecentlyUpdatedMovieImpl implements TraktRecentlyUpdatedMovie {
	@SerializedName("updated_at")
	private Date updatedAt;
	private TraktMovieImpl movie;

	@Override
	public Date getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public TraktRecentlyUpdatedMovie withUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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
	public TraktRecentlyUpdatedMovie withMovie(TraktMovieImpl movie) {
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
	public TraktRecentlyUpdatedMovieImpl withTitle(String title) {
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
	public TraktRecentlyUpdatedMovieImpl withYear(Integer year) {
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
	public TraktRecentlyUpdatedMovieImpl withIds(TraktMovieIds ids) {
		if (movie != null) movie.withIds(ids);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktRecentlyUpdatedMovieImpl that = (TraktRecentlyUpdatedMovieImpl) o;

		return (updatedAt != null ? updatedAt.equals(that.updatedAt) : that.updatedAt == null) && (movie != null ? movie
				.equals(that.movie) : that.movie == null);
	}

	@Override
	public int hashCode() {
		int result = updatedAt != null ? updatedAt.hashCode() : 0;
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktRecentlyUpdatedMovie{" + "updatedAt=" + updatedAt + ", movie=" + movie + '}';
	}
}
