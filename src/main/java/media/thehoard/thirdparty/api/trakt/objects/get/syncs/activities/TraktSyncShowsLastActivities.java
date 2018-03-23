package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.time.Instant;
import java.util.Date;

public interface TraktSyncShowsLastActivities {
	Instant getRatedAt();

	void setRatedAt(Instant ratedAt);

	TraktSyncShowsLastActivities withRatedAt(Instant ratedAt);

	Instant getWatchlistedAt();

	void setWatchlistedAt(Instant watchlistedAt);

	TraktSyncShowsLastActivities withWatchlistedAt(Instant watchlistedAt);

	Instant getCommentedAt();

	void setCommentedAt(Instant commentedAt);

	TraktSyncShowsLastActivities withCommentedAt(Instant commentedAt);

	Instant getHiddenAt();

	void setHiddenAt(Instant hiddenAt);

	TraktSyncShowsLastActivities withHiddenAt(Instant hiddenAt);
}
