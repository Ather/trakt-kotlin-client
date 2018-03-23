package media.thehoard.thirdparty.api.trakt.objects.get.shows;

import media.thehoard.thirdparty.api.trakt.enums.TraktShowStatus;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowAirsImpl;

import java.time.Instant;
import java.util.List;

public interface TraktShowExtended extends TraktShow<TraktShowExtended> {
	String getOverview();

	void setOverview(String overview);

	TraktShowExtended withOverview(String overview);

	Instant getFirstAired();

	void setFirstAired(Instant firstAired);

	TraktShowExtended withFirstAired(Instant firstAired);

	TraktShowAirs getAirs();

	void setAirs(TraktShowAirsImpl airs);

	TraktShowExtended withAirs(TraktShowAirsImpl airs);

	Integer getRuntime();

	void setRuntime(Integer runtime);

	TraktShowExtended withRuntime(Integer runtime);

	String getCertification();

	void setCertification(String certification);

	TraktShowExtended withCertification(String certification);

	String getNetwork();

	void setNetwork(String network);

	TraktShowExtended withNetwork(String network);

	String getCountry();

	void setCountry(String country);

	TraktShowExtended withCountry(String country);

	Instant getUpdatedAt();

	void setUpdatedAt(Instant updatedAt);

	TraktShowExtended withUpdatedAt(Instant updatedAt);

	String getTrailer();

	void setTrailer(String trailer);

	TraktShowExtended withTrailer(String trailer);

	String getHomepage();

	void setHomepage(String homepage);

	TraktShowExtended withHomepage(String homepage);

	TraktShowStatus getStatus();

	void setStatus(TraktShowStatus status);

	TraktShowExtended withStatus(TraktShowStatus status);

	Float getRating();

	void setRating(Float rating);

	TraktShowExtended withRating(Float rating);

	Integer getVotes();

	void setVotes(Integer votes);

	TraktShowExtended withVotes(Integer votes);

	Integer getCommentCount();

	void setCommentCount(Integer commentCount);

	TraktShowExtended withCommentCount(Integer commentCount);

	String getLanguage();

	void setLanguage(String language);

	TraktShowExtended withLanguage(String language);

	List<String> getAvailableTranslations();

	void setAvailableTranslations(List<String> availableTranslations);

	TraktShowExtended withAvailableTranslations(List<String> availableTranslations);

	List<String> getGenres();

	void setGenres(List<String> genres);

	TraktShowExtended withGenres(List<String> genres);

	Integer getAiredEpisodes();

	void setAiredEpisodes(Integer airedEpisodes);

	TraktShowExtended withAiredEpisodes(Integer airedEpisodes);
}
