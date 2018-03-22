package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics;

public interface TraktUserShowsStatistics {
	Integer getWatched();

	void setWatched(Integer watched);

	TraktUserShowsStatistics withWatched(Integer watched);

	Integer getCollected();

	void setCollected(Integer collected);

	TraktUserShowsStatistics withCollected(Integer collected);

	Integer getRatings();

	void setRatings(Integer ratings);

	TraktUserShowsStatistics withRatings(Integer ratings);

	Integer getComments();

	void setComments(Integer comments);

	TraktUserShowsStatistics withComments(Integer comments);
}
