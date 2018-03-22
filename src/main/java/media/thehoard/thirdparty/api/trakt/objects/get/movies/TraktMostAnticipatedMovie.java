package media.thehoard.thirdparty.api.trakt.objects.get.movies;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

public interface TraktMostAnticipatedMovie extends TraktMovie<TraktMostAnticipatedMovie> {
	Integer getListCount();

	void setListCount(Integer listCount);

	TraktMostAnticipatedMovie withListCount(Integer listCount);

	TraktMovie getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktMostAnticipatedMovie withMovie(TraktMovieImpl movie);
}
