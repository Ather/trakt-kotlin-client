package media.thehoard.thirdparty.api.trakt.objects.get.movies;

import media.thehoard.thirdparty.api.trakt.enums.TraktReleaseType;

import java.util.Date;

public interface TraktMovieRelease {
	String getCountry();

	void setCountry(String country);

	TraktMovieRelease withCountry(String country);

	String getCertification();

	void setCertification(String certification);

	TraktMovieRelease withCertification(String certification);

	Date getReleaseDate();

	void setReleaseDate(Date releaseDate);

	TraktMovieRelease withReleaseDate(Date releaseDate);

	TraktReleaseType getReleaseType();

	void setReleaseType(TraktReleaseType releaseType);

	TraktMovieRelease withReleaseType(TraktReleaseType releaseType);

	String getNote();

	void setNote(String note);

	TraktMovieRelease withNote(String note);
}
