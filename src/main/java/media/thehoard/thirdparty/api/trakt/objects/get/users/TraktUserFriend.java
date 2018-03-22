package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl;

import java.util.Date;

public interface TraktUserFriend {
	Date getFriendsAt();

	void setFriendsAt(Date friendsAt);

	TraktUserFriend withFriendsAt(Date friendsAt);

	TraktUser getUser();

	void setUser(TraktUserImpl user);

	TraktUserFriend withUser(TraktUserImpl user);
}
