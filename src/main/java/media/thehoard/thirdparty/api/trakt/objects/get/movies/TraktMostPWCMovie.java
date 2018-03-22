package media.thehoard.thirdparty.api.trakt.objects.get.movies;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

public interface TraktMostPWCMovie extends TraktMovie<TraktMostPWCMovie> {
	TraktMostPWCMovie withPlayCount(Integer playCount);

	Integer getCollectedCount();

	void setCollectedCount(Integer collectedCount);

	TraktMostPWCMovie withCollectedCount(Integer collectedCount);

	TraktMovie getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktMostPWCMovie withMovie(TraktMovieImpl movie);
}
