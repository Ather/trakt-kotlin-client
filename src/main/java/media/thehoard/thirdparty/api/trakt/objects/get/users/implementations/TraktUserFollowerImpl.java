package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserFollower;

import java.time.Instant;

public class TraktUserFollowerImpl implements TraktUserFollower {
	@SerializedName("followed_at")
	private Instant followedAt;
	private TraktUserImpl user;

	@Override
	public Instant getFollowedAt() {
		return followedAt;
	}

	@Override
	public void setFollowedAt(Instant followedAt) {
		this.followedAt = followedAt;
	}

	@Override
	public TraktUserFollower withFollowedAt(Instant followedAt) {
		this.followedAt = followedAt;
		return this;
	}

	@Override
	public TraktUser getUser() {
		return user;
	}

	@Override
	public void setUser(TraktUserImpl user) {
		this.user = user;
	}

	@Override
	public TraktUserFollower withUser(TraktUserImpl user) {
		this.user = user;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserFollowerImpl that = (TraktUserFollowerImpl) o;

		if (followedAt != null ? !followedAt.equals(that.followedAt) : that.followedAt != null) return false;
		return user != null ? user.equals(that.user) : that.user == null;
	}

	@Override
	public int hashCode() {
		int result = followedAt != null ? followedAt.hashCode() : 0;
		result = 31 * result + (user != null ? user.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserFollower{" + "followedAt=" + followedAt + ", user=" + user + '}';
	}
}
