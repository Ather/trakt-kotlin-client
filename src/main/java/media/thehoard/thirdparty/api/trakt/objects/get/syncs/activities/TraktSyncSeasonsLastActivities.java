package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.time.Instant;
import java.util.Date;

public interface TraktSyncSeasonsLastActivities {
	Instant getRatedAt();

	void setRatedAt(Instant ratedAt);

	TraktSyncSeasonsLastActivities withRatedAt(Instant ratedAt);

	Instant getWatchlistedAt();

	void setWatchlistedAt(Instant watchlistedAt);

	TraktSyncSeasonsLastActivities withWatchlistedAt(Instant watchlistedAt);

	Instant getCommentedAt();

	void setCommentedAt(Instant commentedAt);

	TraktSyncSeasonsLastActivities withCommentedAt(Instant commentedAt);

	Instant getHiddenAt();

	void setHiddenAt(Instant hiddenAt);

	TraktSyncSeasonsLastActivities withHiddenAt(Instant hiddenAt);
}
