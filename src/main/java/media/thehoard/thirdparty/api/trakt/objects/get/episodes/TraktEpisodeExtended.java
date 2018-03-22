package media.thehoard.thirdparty.api.trakt.objects.get.episodes;

import java.util.Date;
import java.util.List;

public interface TraktEpisodeExtended extends TraktEpisode<TraktEpisodeExtended> {
	Integer getNumberAbsolute();

	void setNumberAbsolute(Integer numberAbsolute);

	TraktEpisodeExtended withNumberAbsolute(Integer numberAbsolute);

	String getOverview();

	void setOverview(String overview);

	TraktEpisodeExtended withOverview(String overview);

	Date getFirstAired();

	void setFirstAired(Date firstAired);

	TraktEpisodeExtended withFirstAired(Date firstAired);

	Date getUpdatedAt();

	void setUpdatedAt(Date updatedAt);

	TraktEpisodeExtended withUpdatedAt(Date updatedAt);

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
