package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl;

import java.util.Date;

public interface TraktUserFollower {
	Date getFollowedAt();

	void setFollowedAt(Date followedAt);

	TraktUserFollower withFollowedAt(Date followedAt);

	TraktUser getUser();

	void setUser(TraktUserImpl user);

	TraktUserFollower withUser(TraktUserImpl user);
}
