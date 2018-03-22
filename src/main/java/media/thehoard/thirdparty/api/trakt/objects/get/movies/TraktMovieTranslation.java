package media.thehoard.thirdparty.api.trakt.objects.get.movies;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktTranslation;

public interface TraktMovieTranslation extends TraktTranslation<TraktMovieTranslation> {
	String getTagline();

	void setTagline(String tagline);

	TraktMovieTranslation withTagline(String tagline);
}
