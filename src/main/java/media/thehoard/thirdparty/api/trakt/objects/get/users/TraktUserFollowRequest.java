package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.objects.get.users.implementations.TraktUserImpl;

import java.util.Date;

public interface TraktUserFollowRequest {
	int getId();

	void setId(int id);

	TraktUserFollowRequest withId(int id);

	Date getRequestedAt();

	void setRequestedAt(Date requestedAt);

	TraktUserFollowRequest withRequestedAt(Date requestedAt);

	TraktUser getUser();

	void setUser(TraktUserImpl user);

	TraktUserFollowRequest withUser(TraktUserImpl user);
}
