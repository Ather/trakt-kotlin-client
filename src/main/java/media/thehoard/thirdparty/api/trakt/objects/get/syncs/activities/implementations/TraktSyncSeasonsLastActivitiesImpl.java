package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncSeasonsLastActivities;

import java.util.Date;

public class TraktSyncSeasonsLastActivitiesImpl implements TraktSyncSeasonsLastActivities {
	@SerializedName("rated_at")
	private Date ratedAt;
	@SerializedName("watchlisted_at")
	private Date watchlistedAt;
	@SerializedName("commented_at")
	private Date commentedAt;
	@SerializedName("hidden_at")
	private Date hiddenAt;

	@Override
	public Date getRatedAt() {
		return ratedAt;
	}

	@Override
	public void setRatedAt(Date ratedAt) {
		this.ratedAt = ratedAt;
	}

	@Override
	public TraktSyncSeasonsLastActivities withRatedAt(Date ratedAt) {
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
	public TraktSyncSeasonsLastActivities withWatchlistedAt(Date watchlistedAt) {
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
	public TraktSyncSeasonsLastActivities withCommentedAt(Date commentedAt) {
		this.commentedAt = commentedAt;
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
	public TraktSyncSeasonsLastActivities withHiddenAt(Date hiddenAt) {
		this.hiddenAt = hiddenAt;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSyncSeasonsLastActivitiesImpl that = (TraktSyncSeasonsLastActivitiesImpl) o;

		if (ratedAt != null ? !ratedAt.equals(that.ratedAt) : that.ratedAt != null) return false;
		if (watchlistedAt != null ? !watchlistedAt.equals(that.watchlistedAt) : that.watchlistedAt != null)
			return false;
		if (commentedAt != null ? !commentedAt.equals(that.commentedAt) : that.commentedAt != null) return false;
		return hiddenAt != null ? hiddenAt.equals(that.hiddenAt) : that.hiddenAt == null;
	}

	@Override
	public int hashCode() {
		int result = ratedAt != null ? ratedAt.hashCode() : 0;
		result = 31 * result + (watchlistedAt != null ? watchlistedAt.hashCode() : 0);
		result = 31 * result + (commentedAt != null ? commentedAt.hashCode() : 0);
		result = 31 * result + (hiddenAt != null ? hiddenAt.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSyncSeasonsLastActivities{" + "ratedAt=" + ratedAt + ", watchlistedAt=" + watchlistedAt + ", commentedAt=" + commentedAt + ", hiddenAt=" + hiddenAt + '}';
	}
}
