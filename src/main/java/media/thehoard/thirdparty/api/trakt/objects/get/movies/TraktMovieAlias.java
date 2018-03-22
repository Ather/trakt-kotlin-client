package media.thehoard.thirdparty.api.trakt.objects.get.movies;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieAliasImpl;

public interface TraktMovieAlias {
	String getTitle();

	void setTitle(String title);

	TraktMovieAliasImpl withTitle(String title);

	String getCountry();

	void setCountry(String country);

	TraktMovieAliasImpl withCountry(String country);
}
