package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl;

import java.time.Instant;

public interface TraktUserFriend {
	Instant getFriendsAt();

	void setFriendsAt(Instant friendsAt);

	TraktUserFriend withFriendsAt(Instant friendsAt);

	TraktUser getUser();

	void setUser(TraktUserImpl user);

	TraktUserFriend withUser(TraktUserImpl user);
}
