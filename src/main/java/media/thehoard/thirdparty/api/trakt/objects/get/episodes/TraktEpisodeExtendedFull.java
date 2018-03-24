package media.thehoard.thirdparty.api.trakt.objects.get.episodes;

import java.time.Instant;
import java.util.List;

public interface TraktEpisodeExtendedFull extends TraktEpisode<TraktEpisodeExtendedFull> {
	Integer getNumberAbsolute();

	void setNumberAbsolute(Integer numberAbsolute);

	TraktEpisodeExtendedFull withNumberAbsolute(Integer numberAbsolute);

	String getOverview();

	void setOverview(String overview);

	TraktEpisodeExtendedFull withOverview(String overview);

	Instant getFirstAired();

	void setFirstAired(Instant firstAired);

	TraktEpisodeExtendedFull withFirstAired(Instant firstAired);

	Instant getUpdatedAt();

	void setUpdatedAt(Instant updatedAt);

	TraktEpisodeExtendedFull withUpdatedAt(Instant updatedAt);

	Float getRating();

	void setRating(Float rating);

	TraktEpisodeExtendedFull withRating(Float rating);

	Integer getVotes();

	void setVotes(Integer votes);

	TraktEpisodeExtendedFull withVotes(Integer votes);

	Integer getCommentCount();

	void setCommentCount(Integer commentCount);

	TraktEpisodeExtendedFull withCommentCount(Integer commentCount);

	List<String> getAvailableTranslations();

	void setAvailableTranslations(List<String> availableTranslations);

	TraktEpisodeExtendedFull withAvailableTranslations(List<String> availableTranslations);

	Integer getRuntime();

	void setRuntime(Integer runtime);

	TraktEpisodeExtendedFull withRuntime(Integer runtime);
}
