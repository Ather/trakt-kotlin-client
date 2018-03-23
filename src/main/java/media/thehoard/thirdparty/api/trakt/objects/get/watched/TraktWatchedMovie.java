package media.thehoard.thirdparty.api.trakt.objects.get.watched;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

import java.time.Instant;

public interface TraktWatchedMovie {
	Integer getPlays();

	void setPlays(Integer plays);

	TraktWatchedMovie withPlays(Integer plays);

	Instant getLastWatchedAt();

	void setLastWatchedAt(Instant lastWatchedAt);

	TraktWatchedMovie withLastWatchedAt(Instant lastWatchedAt);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktWatchedMovie withMovie(TraktMovieImpl movie);
}
