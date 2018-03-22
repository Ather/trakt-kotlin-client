package media.thehoard.thirdparty.api.trakt.objects.get.movies;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

import java.util.Date;

public interface TraktRecentlyUpdatedMovie extends TraktMovie<TraktRecentlyUpdatedMovie> {
	Date getUpdatedAt();

	void setUpdatedAt(Date updatedAt);

	TraktRecentlyUpdatedMovie withUpdatedAt(Date updatedAt);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktRecentlyUpdatedMovie withMovie(TraktMovieImpl movie);
}
