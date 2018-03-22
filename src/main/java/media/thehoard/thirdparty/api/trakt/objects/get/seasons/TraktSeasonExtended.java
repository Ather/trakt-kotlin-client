package media.thehoard.thirdparty.api.trakt.objects.get.seasons;

import java.util.Date;

public interface TraktSeasonExtended extends TraktSeason {
	Float getRating();

	void setRating(Float rating);

	TraktSeasonExtended withRating(Float rating);

	Integer getVotes();

	void setVotes(Integer votes);

	TraktSeasonExtended withVotes(Integer votes);

	Integer getEpisodeCount();

	void setEpisodeCount(Integer episodeCount);

	TraktSeasonExtended withEpisodeCount(Integer episodeCount);

	Integer getAiredEpisodes();

	void setAiredEpisodes(Integer airedEpisodes);

	TraktSeasonExtended withAiredEpisodes(Integer airedEpisodes);

	String getTitle();

	void setTitle(String title);

	TraktSeasonExtended withTitle(String title);

	String getOverview();

	void setOverview(String overview);

	TraktSeasonExtended withOverview(String overview);

	Date getFirstAired();

	void setFirstAired(Date firstAired);

	TraktSeasonExtended withFirstAired(Date firstAired);

	String getNetwork();

	void setNetwork(String network);

	TraktSeasonExtended withNetwork(String network);
}
