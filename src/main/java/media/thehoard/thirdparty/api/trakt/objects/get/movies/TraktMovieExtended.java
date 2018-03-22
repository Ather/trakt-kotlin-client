package media.thehoard.thirdparty.api.trakt.objects.get.movies;

import java.util.Date;
import java.util.List;

public interface TraktMovieExtended extends TraktMovie<TraktMovieExtended> {
	String getTagline();

	void setTagline(String tagline);

	TraktMovieExtended withTagline(String tagline);

	String getOverview();

	void setOverview(String overview);

	TraktMovieExtended withOverview(String overview);

	Date getReleased();

	void setReleased(Date released);

	TraktMovieExtended withReleased(Date released);

	Integer getRuntime();

	void setRuntime(Integer runtime);

	TraktMovieExtended withRuntime(Integer runtime);

	Date getUpdatedAt();

	void setUpdatedAt(Date updatedAt);

	TraktMovieExtended withUpdatedAt(Date updatedAt);

	String getTrailer();

	void setTrailer(String trailer);

	TraktMovieExtended withTrailer(String trailer);

	String getHomepage();

	void setHomepage(String homepage);

	TraktMovieExtended withHomepage(String homepage);

	Float getRating();

	void setRating(Float rating);

	TraktMovieExtended withRating(Float rating);

	Integer getVotes();

	void setVotes(Integer votes);

	TraktMovieExtended withVotes(Integer votes);

	Integer getCommentCount();

	void setCommentCount(Integer commentCount);

	TraktMovieExtended withCommentCount(Integer commentCount);

	String getLanguage();

	void setLanguage(String language);

	TraktMovieExtended withLanguage(String language);

	List<String> getAvailableTranslations();

	void setAvailableTranslations(List<String> availableTranslations);

	TraktMovieExtended withAvailableTranslations(List<String> availableTranslations);

	List<String> getGenres();

	void setGenres(List<String> genres);

	TraktMovieExtended withGenres(List<String> genres);

	String getCertification();

	void setCertification(String certification);

	TraktMovieExtended withCertification(String certification);
}
