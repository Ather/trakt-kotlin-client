package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;

import java.util.Date;

public interface TraktCheckinPostResponse<T extends TraktCheckinPostResponse<T>> {
	long getId();

	void setId(long id);

	T withId(long id);

	Date getWatchedAt();

	void setWatchedAt(Date watchedAt);

	T withWatchedAt(Date watchedAt);

	TraktSharingImpl getSharing();

	void setSharing(TraktSharingImpl sharing);

	T withSharing(TraktSharingImpl sharing);
}
