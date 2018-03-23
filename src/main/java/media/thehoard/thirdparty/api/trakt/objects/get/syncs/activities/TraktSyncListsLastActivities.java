package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.time.Instant;
import java.util.Date;

public interface TraktSyncListsLastActivities {
	Instant getLikedAt();

	void setLikedAt(Instant likedAt);

	TraktSyncListsLastActivities withLikedAt(Instant likedAt);

	Instant getUpdatedAt();

	void setUpdatedAt(Instant updatedAt);

	TraktSyncListsLastActivities withUpdatedAt(Instant updatedAt);

	Instant getCommentedAt();

	void setCommentedAt(Instant commentedAt);

	TraktSyncListsLastActivities withCommentedAt(Instant commentedAt);
}
