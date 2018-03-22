package media.thehoard.thirdparty.api.trakt.objects.get.watched;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

import java.util.Date;

public interface TraktWatchedMovie {
	Integer getPlays();

	void setPlays(Integer plays);

	TraktWatchedMovie withPlays(Integer plays);

	Date getLastWatchedAt();

	void setLastWatchedAt(Date lastWatchedAt);

	TraktWatchedMovie withLastWatchedAt(Date lastWatchedAt);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktWatchedMovie withMovie(TraktMovieImpl movie);
}
