package media.thehoard.thirdparty.api.trakt.objects.get.movies;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;

public interface TraktBoxOfficeMovie extends TraktMovie<TraktBoxOfficeMovie> {
	Long getRevenue();

	void setRevenue(Long revenue);

	TraktBoxOfficeMovie withRevenue(Long revenue);

	TraktMovie getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktBoxOfficeMovie withMovie(TraktMovieImpl movie);
}
