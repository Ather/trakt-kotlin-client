package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl;

import java.time.Instant;

public interface TraktUserFollower {
	Instant getFollowedAt();

	void setFollowedAt(Instant followedAt);

	TraktUserFollower withFollowedAt(Instant followedAt);

	TraktUser getUser();

	void setUser(TraktUserImpl user);

	TraktUserFollower withUser(TraktUserImpl user);
}
