package media.thehoard.thirdparty.api.trakt.objects.get.calendars;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

import java.util.Date;

public interface TraktCalendarMovie extends TraktMovie<TraktCalendarMovie> {
	Date getReleased();

	void setReleased(Date released);

	TraktCalendarMovie withReleased(Date released);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktCalendarMovie withMovie(TraktMovieImpl movie);
}
