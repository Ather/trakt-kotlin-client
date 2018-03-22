package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.util.Date;

public interface TraktSyncEpisodesLastActivities {
	Date getWatchedAt();

	void setWatchedAt(Date watchedAt);

	TraktSyncEpisodesLastActivities withWatchedAt(Date watchedAt);

	Date getCollectedAt();

	void setCollectedAt(Date collectedAt);

	TraktSyncEpisodesLastActivities withCollectedAt(Date collectedAt);

	Date getRatedAt();

	void setRatedAt(Date ratedAt);

	TraktSyncEpisodesLastActivities withRatedAt(Date ratedAt);

	Date getWatchlistedAt();

	void setWatchlistedAt(Date watchlistedAt);

	TraktSyncEpisodesLastActivities withWatchlistedAt(Date watchlistedAt);

	Date getCommentedAt();

	void setCommentedAt(Date commentedAt);

	TraktSyncEpisodesLastActivities withCommentedAt(Date commentedAt);

	Date getPausedAt();

	void setPausedAt(Date pausedAt);

	TraktSyncEpisodesLastActivities withPausedAt(Date pausedAt);
}
