package media.thehoard.thirdparty.api.trakt.objects.get.movies;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

public interface TraktTrendingMovie extends TraktMovie<TraktTrendingMovie> {
	Integer getWatchers();

	void setWatchers(Integer watchers);

	TraktTrendingMovie withWatchers(Integer watchers);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktTrendingMovie withMovie(TraktMovieImpl movie);
}
