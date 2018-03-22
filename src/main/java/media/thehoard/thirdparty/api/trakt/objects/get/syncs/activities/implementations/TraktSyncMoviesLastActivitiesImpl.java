package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncMoviesLastActivities;

import java.util.Date;

public class TraktSyncMoviesLastActivitiesImpl implements TraktSyncMoviesLastActivities {
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
	@SerializedName("hidden_at")
	private Date hiddenAt;

	@Override
	public Date getWatchedAt() {
		return watchedAt;
	}

	@Override
	public void setWatchedAt(Date watchedAt) {
		this.watchedAt = watchedAt;
	}

	@Override
	public TraktSyncMoviesLastActivities withWatchedAt(Date watchedAt) {
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
	public TraktSyncMoviesLastActivities withCollectedAt(Date collectedAt) {
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
	public TraktSyncMoviesLastActivities withRatedAt(Date ratedAt) {
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
	public TraktSyncMoviesLastActivities withWatchlistedAt(Date watchlistedAt) {
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
	public TraktSyncMoviesLastActivities withCommentedAt(Date commentedAt) {
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
	public TraktSyncMoviesLastActivities withPausedAt(Date pausedAt) {
		this.pausedAt = pausedAt;
		return this;
	}

	@Override
	public Date getHiddenAt() {
		return hiddenAt;
	}

	@Override
	public void setHiddenAt(Date hiddenAt) {
		this.hiddenAt = hiddenAt;
	}

	@Override
	public TraktSyncMoviesLastActivities withHiddenAt(Date hiddenAt) {
		this.hiddenAt = hiddenAt;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSyncMoviesLastActivitiesImpl that = (TraktSyncMoviesLastActivitiesImpl) o;

		if (watchedAt != null ? !watchedAt.equals(that.watchedAt) : that.watchedAt != null) return false;
		if (collectedAt != null ? !collectedAt.equals(that.collectedAt) : that.collectedAt != null) return false;
		if (ratedAt != null ? !ratedAt.equals(that.ratedAt) : that.ratedAt != null) return false;
		if (watchlistedAt != null ? !watchlistedAt.equals(that.watchlistedAt) : that.watchlistedAt != null)
			return false;
		if (commentedAt != null ? !commentedAt.equals(that.commentedAt) : that.commentedAt != null) return false;
		if (pausedAt != null ? !pausedAt.equals(that.pausedAt) : that.pausedAt != null) return false;
		return hiddenAt != null ? hiddenAt.equals(that.hiddenAt) : that.hiddenAt == null;
	}

	@Override
	public int hashCode() {
		int result = watchedAt != null ? watchedAt.hashCode() : 0;
		result = 31 * result + (collectedAt != null ? collectedAt.hashCode() : 0);
		result = 31 * result + (ratedAt != null ? ratedAt.hashCode() : 0);
		result = 31 * result + (watchlistedAt != null ? watchlistedAt.hashCode() : 0);
		result = 31 * result + (commentedAt != null ? commentedAt.hashCode() : 0);
		result = 31 * result + (pausedAt != null ? pausedAt.hashCode() : 0);
		result = 31 * result + (hiddenAt != null ? hiddenAt.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSyncMoviesLastActivities{" + "watchedAt=" + watchedAt + ", collectedAt=" + collectedAt + ", ratedAt=" + ratedAt + ", watchlistedAt=" + watchlistedAt + ", commentedAt=" + commentedAt + ", pausedAt=" + pausedAt + ", hiddenAt=" + hiddenAt + '}';
	}
}
