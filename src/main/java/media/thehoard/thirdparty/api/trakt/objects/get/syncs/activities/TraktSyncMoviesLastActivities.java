package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.time.Instant;
import java.util.Date;

public interface TraktSyncMoviesLastActivities {
	Instant getWatchedAt();

	void setWatchedAt(Instant watchedAt);

	TraktSyncMoviesLastActivities withWatchedAt(Instant watchedAt);

	Instant getCollectedAt();

	void setCollectedAt(Instant collectedAt);

	TraktSyncMoviesLastActivities withCollectedAt(Instant collectedAt);

	Instant getRatedAt();

	void setRatedAt(Instant ratedAt);

	TraktSyncMoviesLastActivities withRatedAt(Instant ratedAt);

	Instant getWatchlistedAt();

	void setWatchlistedAt(Instant watchlistedAt);

	TraktSyncMoviesLastActivities withWatchlistedAt(Instant watchlistedAt);

	Instant getCommentedAt();

	void setCommentedAt(Instant commentedAt);

	TraktSyncMoviesLastActivities withCommentedAt(Instant commentedAt);

	Instant getPausedAt();

	void setPausedAt(Instant pausedAt);

	TraktSyncMoviesLastActivities withPausedAt(Instant pausedAt);

	Instant getHiddenAt();

	void setHiddenAt(Instant hiddenAt);

	TraktSyncMoviesLastActivities withHiddenAt(Instant hiddenAt);
}
