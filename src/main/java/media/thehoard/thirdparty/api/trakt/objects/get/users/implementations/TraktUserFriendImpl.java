package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserFriend;

import java.time.Instant;

public class TraktUserFriendImpl implements TraktUserFriend {
	@SerializedName("friends_at")
	private Instant friendsAt;
	private TraktUserImpl user;

	@Override
	public Instant getFriendsAt() {
		return friendsAt;
	}

	@Override
	public void setFriendsAt(Instant friendsAt) {
		this.friendsAt = friendsAt;
	}

	@Override
	public TraktUserFriend withFriendsAt(Instant friendsAt) {
		this.friendsAt = friendsAt;
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
	public TraktUserFriend withUser(TraktUserImpl user) {
		this.user = user;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserFriendImpl that = (TraktUserFriendImpl) o;

		if (friendsAt != null ? !friendsAt.equals(that.friendsAt) : that.friendsAt != null) return false;
		return user != null ? user.equals(that.user) : that.user == null;
	}

	@Override
	public int hashCode() {
		int result = friendsAt != null ? friendsAt.hashCode() : 0;
		result = 31 * result + (user != null ? user.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserFriend{" + "friendsAt=" + friendsAt + ", user=" + user + '}';
	}
}
