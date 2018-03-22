package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncCommentsLastActivities;

import java.util.Date;

public class TraktSyncCommentsLastActivitiesImpl implements TraktSyncCommentsLastActivities {
	@SerializedName("liked_at")
	private Date likedAt;

	@Override
	public Date getLikedAt() {
		return likedAt;
	}

	@Override
	public void setLikedAt(Date likedAt) {
		this.likedAt = likedAt;
	}

	@Override
	public TraktSyncCommentsLastActivities withLikedAt(Date likedAt) {
		this.likedAt = likedAt;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSyncCommentsLastActivitiesImpl that = (TraktSyncCommentsLastActivitiesImpl) o;

		return likedAt != null ? likedAt.equals(that.likedAt) : that.likedAt == null;
	}

	@Override
	public int hashCode() {
		return likedAt != null ? likedAt.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "TraktSyncCommentsLastActivities{" + "likedAt=" + likedAt + '}';
	}
}
