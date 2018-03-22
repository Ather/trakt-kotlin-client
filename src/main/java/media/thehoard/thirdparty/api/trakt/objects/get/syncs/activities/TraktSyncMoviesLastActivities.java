package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.util.Date;

public interface TraktSyncMoviesLastActivities {
	Date getWatchedAt();

	void setWatchedAt(Date watchedAt);

	TraktSyncMoviesLastActivities withWatchedAt(Date watchedAt);

	Date getCollectedAt();

	void setCollectedAt(Date collectedAt);

	TraktSyncMoviesLastActivities withCollectedAt(Date collectedAt);

	Date getRatedAt();

	void setRatedAt(Date ratedAt);

	TraktSyncMoviesLastActivities withRatedAt(Date ratedAt);

	Date getWatchlistedAt();

	void setWatchlistedAt(Date watchlistedAt);

	TraktSyncMoviesLastActivities withWatchlistedAt(Date watchlistedAt);

	Date getCommentedAt();

	void setCommentedAt(Date commentedAt);

	TraktSyncMoviesLastActivities withCommentedAt(Date commentedAt);

	Date getPausedAt();

	void setPausedAt(Date pausedAt);

	TraktSyncMoviesLastActivities withPausedAt(Date pausedAt);

	Date getHiddenAt();

	void setHiddenAt(Date hiddenAt);

	TraktSyncMoviesLastActivities withHiddenAt(Date hiddenAt);
}
