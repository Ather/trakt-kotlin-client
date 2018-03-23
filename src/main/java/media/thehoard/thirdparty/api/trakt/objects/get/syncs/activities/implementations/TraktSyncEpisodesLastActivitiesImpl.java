package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncEpisodesLastActivities;

import java.time.Instant;
import java.util.Date;

public class TraktSyncEpisodesLastActivitiesImpl implements TraktSyncEpisodesLastActivities {
	@SerializedName("watched_at")
	private Instant watchedAt;
	@SerializedName("collected_at")
	private Instant collectedAt;
	@SerializedName("rated_at")
	private Instant ratedAt;
	@SerializedName("watchlisted_at")
	private Instant watchlistedAt;
	@SerializedName("commented_at")
	private Instant commentedAt;
	@SerializedName("paused_at")
	private Instant pausedAt;

	@Override
	public Instant getWatchedAt() {
		return watchedAt;
	}

	@Override
	public void setWatchedAt(Instant watchedAt) {
		this.watchedAt = watchedAt;
	}

	@Override
	public TraktSyncEpisodesLastActivities withWatchedAt(Instant watchedAt) {
		this.watchedAt = watchedAt;
		return this;
	}

	@Override
	public Instant getCollectedAt() {
		return collectedAt;
	}

	@Override
	public void setCollectedAt(Instant collectedAt) {
		this.collectedAt = collectedAt;
	}

	@Override
	public TraktSyncEpisodesLastActivities withCollectedAt(Instant collectedAt) {
		this.collectedAt = collectedAt;
		return this;
	}

	@Override
	public Instant getRatedAt() {
		return ratedAt;
	}

	@Override
	public void setRatedAt(Instant ratedAt) {
		this.ratedAt = ratedAt;
	}

	@Override
	public TraktSyncEpisodesLastActivities withRatedAt(Instant ratedAt) {
		this.ratedAt = ratedAt;
		return this;
	}

	@Override
	public Instant getWatchlistedAt() {
		return watchlistedAt;
	}

	@Override
	public void setWatchlistedAt(Instant watchlistedAt) {
		this.watchlistedAt = watchlistedAt;
	}

	@Override
	public TraktSyncEpisodesLastActivities withWatchlistedAt(Instant watchlistedAt) {
		this.watchlistedAt = watchlistedAt;
		return this;
	}

	@Override
	public Instant getCommentedAt() {
		return commentedAt;
	}

	@Override
	public void setCommentedAt(Instant commentedAt) {
		this.commentedAt = commentedAt;
	}

	@Override
	public TraktSyncEpisodesLastActivities withCommentedAt(Instant commentedAt) {
		this.commentedAt = commentedAt;
		return this;
	}

	@Override
	public Instant getPausedAt() {
		return pausedAt;
	}

	@Override
	public void setPausedAt(Instant pausedAt) {
		this.pausedAt = pausedAt;
	}

	@Override
	public TraktSyncEpisodesLastActivities withPausedAt(Instant pausedAt) {
		this.pausedAt = pausedAt;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSyncEpisodesLastActivitiesImpl that = (TraktSyncEpisodesLastActivitiesImpl) o;

		if (watchedAt != null ? !watchedAt.equals(that.watchedAt) : that.watchedAt != null) return false;
		if (collectedAt != null ? !collectedAt.equals(that.collectedAt) : that.collectedAt != null) return false;
		if (ratedAt != null ? !ratedAt.equals(that.ratedAt) : that.ratedAt != null) return false;
		if (watchlistedAt != null ? !watchlistedAt.equals(that.watchlistedAt) : that.watchlistedAt != null)
			return false;
		if (commentedAt != null ? !commentedAt.equals(that.commentedAt) : that.commentedAt != null) return false;
		return pausedAt != null ? pausedAt.equals(that.pausedAt) : that.pausedAt == null;
	}

	@Override
	public int hashCode() {
		int result = watchedAt != null ? watchedAt.hashCode() : 0;
		result = 31 * result + (collectedAt != null ? collectedAt.hashCode() : 0);
		result = 31 * result + (ratedAt != null ? ratedAt.hashCode() : 0);
		result = 31 * result + (watchlistedAt != null ? watchlistedAt.hashCode() : 0);
		result = 31 * result + (commentedAt != null ? commentedAt.hashCode() : 0);
		result = 31 * result + (pausedAt != null ? pausedAt.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSyncEpisodesLastActivities{" + "watchedAt=" + watchedAt + ", collectedAt=" + collectedAt + ", ratedAt=" + ratedAt + ", watchlistedAt=" + watchlistedAt + ", commentedAt=" + commentedAt + ", pausedAt=" + pausedAt + '}';
	}
}
