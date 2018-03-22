package media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedMovie;

import java.util.Date;

public class TraktWatchedMovieImpl implements TraktWatchedMovie {
	private Integer plays;
	@SerializedName("last_watched_at")
	private Date lastWatchedAt;
	private TraktMovieImpl movie;

	@Override
	public Integer getPlays() {
		return plays;
	}

	@Override
	public void setPlays(Integer plays) {
		this.plays = plays;
	}

	@Override
	public TraktWatchedMovie withPlays(Integer plays) {
		this.plays = plays;
		return this;
	}

	@Override
	public Date getLastWatchedAt() {
		return lastWatchedAt;
	}

	@Override
	public void setLastWatchedAt(Date lastWatchedAt) {
		this.lastWatchedAt = lastWatchedAt;
	}

	@Override
	public TraktWatchedMovie withLastWatchedAt(Date lastWatchedAt) {
		this.lastWatchedAt = lastWatchedAt;
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
	public TraktWatchedMovie withMovie(TraktMovieImpl movie) {
		this.movie = movie;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktWatchedMovieImpl that = (TraktWatchedMovieImpl) o;

		if (plays != null ? !plays.equals(that.plays) : that.plays != null) return false;
		if (lastWatchedAt != null ? !lastWatchedAt.equals(that.lastWatchedAt) : that.lastWatchedAt != null)
			return false;
		return movie != null ? movie.equals(that.movie) : that.movie == null;
	}

	@Override
	public int hashCode() {
		int result = plays != null ? plays.hashCode() : 0;
		result = 31 * result + (lastWatchedAt != null ? lastWatchedAt.hashCode() : 0);
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktWatchedMovie{" + "plays=" + plays + ", lastWatchedAt=" + lastWatchedAt + ", movie=" + movie + '}';
	}
}
