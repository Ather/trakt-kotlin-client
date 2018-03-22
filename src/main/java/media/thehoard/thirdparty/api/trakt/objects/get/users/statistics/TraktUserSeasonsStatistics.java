package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics;

public interface TraktUserSeasonsStatistics {
	Integer getRatings();

	void setRatings(Integer ratings);

	TraktUserSeasonsStatistics withRatings(Integer ratings);

	Integer getComments();

	void setComments(Integer comments);

	TraktUserSeasonsStatistics withComments(Integer comments);
}
