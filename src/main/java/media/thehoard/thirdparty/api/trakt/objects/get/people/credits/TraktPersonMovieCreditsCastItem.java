package media.thehoard.thirdparty.api.trakt.objects.get.people.credits;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsCastItemImpl;

public interface TraktPersonMovieCreditsCastItem {
	String getCharacter();

	void setCharacter(String character);

	TraktPersonMovieCreditsCastItemImpl withCharacter(String character);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktPersonMovieCreditsCastItemImpl withMovie(TraktMovieImpl movie);
}
