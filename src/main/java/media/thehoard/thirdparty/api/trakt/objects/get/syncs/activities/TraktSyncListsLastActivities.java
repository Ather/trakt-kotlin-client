package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.util.Date;

public interface TraktSyncListsLastActivities {
	Date getLikedAt();

	void setLikedAt(Date likedAt);

	TraktSyncListsLastActivities withLikedAt(Date likedAt);

	Date getUpdatedAt();

	void setUpdatedAt(Date updatedAt);

	TraktSyncListsLastActivities withUpdatedAt(Date updatedAt);

	Date getCommentedAt();

	void setCommentedAt(Date commentedAt);

	TraktSyncListsLastActivities withCommentedAt(Date commentedAt);
}
