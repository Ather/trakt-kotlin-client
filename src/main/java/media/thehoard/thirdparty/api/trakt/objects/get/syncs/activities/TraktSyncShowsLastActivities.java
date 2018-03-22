package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.util.Date;

public interface TraktSyncShowsLastActivities {
	Date getRatedAt();

	void setRatedAt(Date ratedAt);

	TraktSyncShowsLastActivities withRatedAt(Date ratedAt);

	Date getWatchlistedAt();

	void setWatchlistedAt(Date watchlistedAt);

	TraktSyncShowsLastActivities withWatchlistedAt(Date watchlistedAt);

	Date getCommentedAt();

	void setCommentedAt(Date commentedAt);

	TraktSyncShowsLastActivities withCommentedAt(Date commentedAt);

	Date getHiddenAt();

	void setHiddenAt(Date hiddenAt);

	TraktSyncShowsLastActivities withHiddenAt(Date hiddenAt);
}
