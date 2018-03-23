package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl;

import java.time.Instant;

public interface TraktUserFollowRequest {
	int getId();

	void setId(int id);

	TraktUserFollowRequest withId(int id);

	Instant getRequestedAt();

	void setRequestedAt(Instant requestedAt);

	TraktUserFollowRequest withRequestedAt(Instant requestedAt);

	TraktUser getUser();

	void setUser(TraktUserImpl user);

	TraktUserFollowRequest withUser(TraktUserImpl user);
}
