package media.thehoard.thirdparty.api.trakt.objects.get.episodes;

import java.time.Instant;
import java.util.List;

public interface TraktEpisodeExtended extends TraktEpisode<TraktEpisodeExtended> {
	Integer getNumberAbsolute();

	void setNumberAbsolute(Integer numberAbsolute);

	TraktEpisodeExtended withNumberAbsolute(Integer numberAbsolute);

	String getOverview();

	void setOverview(String overview);

	TraktEpisodeExtended withOverview(String overview);

	Instant getFirstAired();

	void setFirstAired(Instant firstAired);

	TraktEpisodeExtended withFirstAired(Instant firstAired);

	Instant getUpdatedAt();

	void setUpdatedAt(Instant updatedAt);

	TraktEpisodeExtended withUpdatedAt(Instant updatedAt);

	Float getRating();

	void setRating(Float rating);

	TraktEpisodeExtended withRating(Float rating);

	Integer getVotes();

	void setVotes(Integer votes);

	TraktEpisodeExtended withVotes(Integer votes);

	Integer getCommentCount();

	void setCommentCount(Integer commentCount);

	TraktEpisodeExtended withCommentCount(Integer commentCount);

	List<String> getAvailableTranslations();

	void setAvailableTranslations(List<String> availableTranslations);

	TraktEpisodeExtended withAvailableTranslations(List<String> availableTranslations);

	Integer getRuntime();

	void setRuntime(Integer runtime);

	TraktEpisodeExtended withRuntime(Integer runtime);
}
