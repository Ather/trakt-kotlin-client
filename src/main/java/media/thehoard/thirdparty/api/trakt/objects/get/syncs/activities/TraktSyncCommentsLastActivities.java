package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.time.Instant;
import java.util.Date;

public interface TraktSyncCommentsLastActivities {
	Instant getLikedAt();

	void setLikedAt(Instant likedAt);

	TraktSyncCommentsLastActivities withLikedAt(Instant likedAt);
}
