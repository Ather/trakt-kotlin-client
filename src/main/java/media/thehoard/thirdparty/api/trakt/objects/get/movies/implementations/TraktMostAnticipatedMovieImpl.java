package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMostAnticipatedMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;

public class TraktMostAnticipatedMovieImpl implements TraktMostAnticipatedMovie {
	@SerializedName("list_count")
	private Integer listCount;
	private TraktMovieImpl movie;

	@Override
	public Integer getListCount() {
		return listCount;
	}

	@Override
	public void setListCount(Integer listCount) {
		this.listCount = listCount;
	}

	@Override
	public TraktMostAnticipatedMovieImpl withListCount(Integer listCount) {
		this.listCount = listCount;
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
	public TraktMostAnticipatedMovieImpl withMovie(TraktMovieImpl movie) {
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
	public TraktMostAnticipatedMovieImpl withTitle(String title) {
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
	public TraktMostAnticipatedMovieImpl withYear(Integer year) {
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
	public TraktMostAnticipatedMovieImpl withIds(TraktMovieIds ids) {
		if (movie != null) movie.withIds(ids);
		return this;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktMostAnticipatedMovieImpl that = (TraktMostAnticipatedMovieImpl) o;

		return (listCount != null ? listCount.equals(that.listCount) : that.listCount == null) && (movie != null ? movie
				.equals(that.movie) : that.movie == null);
	}

	@Override
	public int hashCode() {
		int result = listCount != null ? listCount.hashCode() : 0;
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktMostAnticipatedMovie{" + "listCount=" + listCount + ", movie=" + movie + '}';
	}
}
