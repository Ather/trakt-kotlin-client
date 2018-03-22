package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics;

public interface TraktUserMoviesStatistics {
	Integer getPlays();

	void setPlays(Integer plays);

	TraktUserMoviesStatistics withPlays(Integer plays);

	Integer getWatched();

	void setWatched(Integer watched);

	TraktUserMoviesStatistics withWatched(Integer watched);

	Integer getMinutes();

	void setMinutes(Integer minutes);

	TraktUserMoviesStatistics withMinutes(Integer minutes);

	Integer getCollected();

	void setCollected(Integer collected);

	TraktUserMoviesStatistics withCollected(Integer collected);

	Integer getRatings();

	void setRatings(Integer ratings);

	TraktUserMoviesStatistics withRatings(Integer ratings);

	Integer getComments();

	void setComments(Integer comments);

	TraktUserMoviesStatistics withComments(Integer comments);
}
