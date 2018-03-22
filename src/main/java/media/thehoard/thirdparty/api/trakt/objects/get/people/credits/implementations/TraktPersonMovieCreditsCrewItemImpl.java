package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCrewItem;

public class TraktPersonMovieCreditsCrewItemImpl implements TraktPersonMovieCreditsCrewItem {
	private String job;
	private TraktMovieImpl movie;

	@Override
	public String getJob() {
		return job;
	}

	@Override
	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public TraktPersonMovieCreditsCrewItemImpl withJob(String job) {
		this.job = job;
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
	public TraktPersonMovieCreditsCrewItemImpl withMovie(TraktMovieImpl movie) {
		this.movie = movie;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktPersonMovieCreditsCrewItemImpl that = (TraktPersonMovieCreditsCrewItemImpl) o;

		return (job != null ? job.equals(that.job) : that.job == null) && (movie != null ? movie.equals(that.movie)
				: that.movie == null);
	}

	@Override
	public int hashCode() {
		int result = job != null ? job.hashCode() : 0;
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktPersonMovieCreditsCrewItemImpl{" + "job='" + job + '\'' + ", movie=" + movie + '}';
	}
}
