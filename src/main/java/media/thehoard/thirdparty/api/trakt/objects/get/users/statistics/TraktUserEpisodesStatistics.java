package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics;

public interface TraktUserEpisodesStatistics {
	Integer getPlays();

	void setPlays(Integer plays);

	TraktUserEpisodesStatistics withPlays(Integer plays);

	Integer getWatched();

	void setWatched(Integer watched);

	TraktUserEpisodesStatistics withWatched(Integer watched);

	Integer getMinutes();

	void setMinutes(Integer minutes);

	TraktUserEpisodesStatistics withMinutes(Integer minutes);

	Integer getCollected();

	void setCollected(Integer collected);

	TraktUserEpisodesStatistics withCollected(Integer collected);

	Integer getRatings();

	void setRatings(Integer ratings);

	TraktUserEpisodesStatistics withRatings(Integer ratings);

	Integer getComments();

	void setComments(Integer comments);

	TraktUserEpisodesStatistics withComments(Integer comments);
}
