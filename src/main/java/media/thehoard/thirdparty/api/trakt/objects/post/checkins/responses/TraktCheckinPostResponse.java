package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;

import java.time.Instant;
import java.util.Date;

public interface TraktCheckinPostResponse<T extends TraktCheckinPostResponse<T>> {
	long getId();

	void setId(long id);

	T withId(long id);

	Instant getWatchedAt();

	void setWatchedAt(Instant watchedAt);

	T withWatchedAt(Instant watchedAt);

	TraktSharingImpl getSharing();

	void setSharing(TraktSharingImpl sharing);

	T withSharing(TraktSharingImpl sharing);
}
