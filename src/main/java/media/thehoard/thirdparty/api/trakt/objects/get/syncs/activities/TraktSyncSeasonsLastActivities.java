package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.util.Date;

public interface TraktSyncSeasonsLastActivities {
	Date getRatedAt();

	void setRatedAt(Date ratedAt);

	TraktSyncSeasonsLastActivities withRatedAt(Date ratedAt);

	Date getWatchlistedAt();

	void setWatchlistedAt(Date watchlistedAt);

	TraktSyncSeasonsLastActivities withWatchlistedAt(Date watchlistedAt);

	Date getCommentedAt();

	void setCommentedAt(Date commentedAt);

	TraktSyncSeasonsLastActivities withCommentedAt(Date commentedAt);

	Date getHiddenAt();

	void setHiddenAt(Date hiddenAt);

	TraktSyncSeasonsLastActivities withHiddenAt(Date hiddenAt);
}
