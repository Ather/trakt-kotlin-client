package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.TraktUserNetworkStatistics;

public class TraktUserNetworkStatisticsImpl implements TraktUserNetworkStatistics {
	private Integer friends;
	private Integer followers;
	private Integer following;

	@Override
	public Integer getFriends() {
		return friends;
	}

	@Override
	public void setFriends(Integer friends) {
		this.friends = friends;
	}

	@Override
	public TraktUserNetworkStatistics withFriends(Integer friends) {
		this.friends = friends;
		return this;
	}

	@Override
	public Integer getFollowers() {
		return followers;
	}

	@Override
	public void setFollowers(Integer followers) {
		this.followers = followers;
	}

	@Override
	public TraktUserNetworkStatistics withFollowers(Integer followers) {
		this.followers = followers;
		return this;
	}

	@Override
	public Integer getFollowing() {
		return following;
	}

	@Override
	public void setFollowing(Integer following) {
		this.following = following;
	}

	@Override
	public TraktUserNetworkStatistics withFollowing(Integer following) {
		this.following = following;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserNetworkStatisticsImpl that = (TraktUserNetworkStatisticsImpl) o;

		if (friends != null ? !friends.equals(that.friends) : that.friends != null) return false;
		if (followers != null ? !followers.equals(that.followers) : that.followers != null) return false;
		return following != null ? following.equals(that.following) : that.following == null;
	}

	@Override
	public int hashCode() {
		int result = friends != null ? friends.hashCode() : 0;
		result = 31 * result + (followers != null ? followers.hashCode() : 0);
		result = 31 * result + (following != null ? following.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserNetworkStatistics{" + "friends=" + friends + ", followers=" + followers + ", following=" + following + '}';
	}
}
