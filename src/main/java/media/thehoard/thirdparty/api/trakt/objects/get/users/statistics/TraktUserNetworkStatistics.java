package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics;

public interface TraktUserNetworkStatistics {
	Integer getFriends();

	void setFriends(Integer friends);

	TraktUserNetworkStatistics withFriends(Integer friends);

	Integer getFollowers();

	void setFollowers(Integer followers);

	TraktUserNetworkStatistics withFollowers(Integer followers);

	Integer getFollowing();

	void setFollowing(Integer following);

	TraktUserNetworkStatistics withFollowing(Integer following);
}
