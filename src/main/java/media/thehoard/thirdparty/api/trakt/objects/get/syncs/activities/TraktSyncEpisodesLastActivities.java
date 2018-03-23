package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.time.Instant;
import java.util.Date;

public interface TraktSyncEpisodesLastActivities {
	Instant getWatchedAt();

	void setWatchedAt(Instant watchedAt);

	TraktSyncEpisodesLastActivities withWatchedAt(Instant watchedAt);

	Instant getCollectedAt();

	void setCollectedAt(Instant collectedAt);

	TraktSyncEpisodesLastActivities withCollectedAt(Instant collectedAt);

	Instant getRatedAt();

	void setRatedAt(Instant ratedAt);

	TraktSyncEpisodesLastActivities withRatedAt(Instant ratedAt);

	Instant getWatchlistedAt();

	void setWatchlistedAt(Instant watchlistedAt);

	TraktSyncEpisodesLastActivities withWatchlistedAt(Instant watchlistedAt);

	Instant getCommentedAt();

	void setCommentedAt(Instant commentedAt);

	TraktSyncEpisodesLastActivities withCommentedAt(Instant commentedAt);

	Instant getPausedAt();

	void setPausedAt(Instant pausedAt);

	TraktSyncEpisodesLastActivities withPausedAt(Instant pausedAt);
}
