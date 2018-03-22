package media.thehoard.thirdparty.api.trakt.objects.get.people.credits;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsCrewItemImpl;

public interface TraktPersonMovieCreditsCrewItem {
	String getJob();

	void setJob(String job);

	TraktPersonMovieCreditsCrewItemImpl withJob(String job);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktPersonMovieCreditsCrewItemImpl withMovie(TraktMovieImpl movie);
}
