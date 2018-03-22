package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.util.Date;

public interface TraktSyncCommentsLastActivities {
	Date getLikedAt();

	void setLikedAt(Date likedAt);

	TraktSyncCommentsLastActivities withLikedAt(Date likedAt);
}
