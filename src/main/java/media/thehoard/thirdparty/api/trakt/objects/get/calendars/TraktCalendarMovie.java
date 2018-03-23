package media.thehoard.thirdparty.api.trakt.objects.get.calendars;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

import java.time.Instant;
import java.util.Date;

public interface TraktCalendarMovie extends TraktMovie<TraktCalendarMovie> {
	Instant getReleased();

	void setReleased(Instant released);

	TraktCalendarMovie withReleased(Instant released);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktCalendarMovie withMovie(TraktMovieImpl movie);
}
