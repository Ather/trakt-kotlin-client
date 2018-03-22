package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncEpisodesLastActivities;

import java.util.Date;

public class TraktSyncEpisodesLastActivitiesImpl implements TraktSyncEpisodesLastActivities {
	@SerializedName("watched_at")
	private Date watchedAt;
	@SerializedName("collected_at")
	private Date collectedAt;
	@SerializedName("rated_at")
	private Date ratedAt;
	@SerializedName("watchlisted_at")
	private Date watchlistedAt;
	@SerializedName("commented_at")
	private Date commentedAt;
	@SerializedName("paused_at")
	private Date pausedAt;

	@Override
	public Date getWatchedAt() {
		return watchedAt;
	}

	@Override
	public void setWatchedAt(Date watchedAt) {
		this.watchedAt = watchedAt;
	}

	@Override
	public TraktSyncEpisodesLastActivities withWatchedAt(Date watchedAt) {
		this.watchedAt = watchedAt;
		return this;
	}

	@Override
	public Date getCollectedAt() {
		return collectedAt;
	}

	@Override
	public void setCollectedAt(Date collectedAt) {
		this.collectedAt = collectedAt;
	}

	@Override
	public TraktSyncEpisodesLastActivities withCollectedAt(Date collectedAt) {
		this.collectedAt = collectedAt;
		return this;
	}

	@Override
	public Date getRatedAt() {
		return ratedAt;
	}

	@Override
	public void setRatedAt(Date ratedAt) {
		this.ratedAt = ratedAt;
	}

	@Override
	public TraktSyncEpisodesLastActivities withRatedAt(Date ratedAt) {
		this.ratedAt = ratedAt;
		return this;
	}

	@Override
	public Date getWatchlistedAt() {
		return watchlistedAt;
	}

	@Override
	public void setWatchlistedAt(Date watchlistedAt) {
		this.watchlistedAt = watchlistedAt;
	}

	@Override
	public TraktSyncEpisodesLastActivities withWatchlistedAt(Date watchlistedAt) {
		this.watchlistedAt = watchlistedAt;
		return this;
	}

	@Override
	public Date getCommentedAt() {
		return commentedAt;
	}

	@Override
	public void setCommentedAt(Date commentedAt) {
		this.commentedAt = commentedAt;
	}

	@Override
	public TraktSyncEpisodesLastActivities withCommentedAt(Date commentedAt) {
		this.commentedAt = commentedAt;
		return this;
	}

	@Override
	public Date getPausedAt() {
		return pausedAt;
	}

	@Override
	public void setPausedAt(Date pausedAt) {
		this.pausedAt = pausedAt;
	}

	@Override
	public TraktSyncEpisodesLastActivities withPausedAt(Date pausedAt) {
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
