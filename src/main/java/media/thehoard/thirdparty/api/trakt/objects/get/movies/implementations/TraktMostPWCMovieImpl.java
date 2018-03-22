package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMostPWCMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;

public class TraktMostPWCMovieImpl implements TraktMostPWCMovie {
	@SerializedName("watcher_count")
	private Integer watcherCount;
	@SerializedName("play_count")
	private Integer playCount;
	@SerializedName("collected_count")
	private Integer collectedCount;
	private TraktMovieImpl movie;

	public Integer getWatcherCount() {
		return watcherCount;
	}

	public void setWatcherCount(Integer watcherCount) {
		this.watcherCount = watcherCount;
	}

	public TraktMostPWCMovieImpl withWatcherCount(Integer watcherCount) {
		this.watcherCount = watcherCount;
		return this;
	}

	public Integer getPlayCount() {
		return playCount;
	}

	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}

	@Override
	public TraktMostPWCMovieImpl withPlayCount(Integer playCount) {
		this.playCount = playCount;
		return this;
	}

	@Override
	public Integer getCollectedCount() {
		return collectedCount;

	}

	@Override
	public void setCollectedCount(Integer collectedCount) {
		this.collectedCount = collectedCount;
	}

	@Override
	public TraktMostPWCMovieImpl withCollectedCount(Integer collectedCount) {
		this.collectedCount = collectedCount;
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
	public TraktMostPWCMovieImpl withMovie(TraktMovieImpl movie) {
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
	public TraktMostPWCMovieImpl withTitle(String title) {
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
	public TraktMostPWCMovieImpl withYear(Integer year) {
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
	public TraktMostPWCMovieImpl withIds(TraktMovieIds ids) {
		if (movie != null) movie.withIds(ids);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktMostPWCMovieImpl that = (TraktMostPWCMovieImpl) o;

		return (watcherCount != null ? watcherCount.equals(that.watcherCount) : that.watcherCount == null) && (
				playCount != null ? playCount.equals(that.playCount) : that.playCount == null) && (
				collectedCount != null ? collectedCount.equals(that.collectedCount) : that.collectedCount == null) && (
				movie != null ? movie.equals(that.movie) : that.movie == null);
	}

	@Override
	public int hashCode() {
		int result = watcherCount != null ? watcherCount.hashCode() : 0;
		result = 31 * result + (playCount != null ? playCount.hashCode() : 0);
		result = 31 * result + (collectedCount != null ? collectedCount.hashCode() : 0);
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktMostPWCMovie{" + "watcherCount=" + watcherCount + ", playCount=" + playCount + ", collectedCount=" + collectedCount + ", movie=" + movie + '}';
	}
}
