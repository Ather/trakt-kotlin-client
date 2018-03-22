package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities.TraktSyncListsLastActivities;

import java.util.Date;

public class TraktSyncListsLastActivitiesImpl implements TraktSyncListsLastActivities {
	@SerializedName("liked_at")
	private Date likedAt;
	@SerializedName("updated_at")
	private Date updatedAt;
	@SerializedName("commented_at")
	private Date commentedAt;

	@Override
	public Date getLikedAt() {
		return likedAt;
	}

	@Override
	public void setLikedAt(Date likedAt) {
		this.likedAt = likedAt;
	}

	@Override
	public TraktSyncListsLastActivities withLikedAt(Date likedAt) {
		this.likedAt = likedAt;
		return this;
	}

	@Override
	public Date getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public TraktSyncListsLastActivities withUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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
	public TraktSyncListsLastActivities withCommentedAt(Date commentedAt) {
		this.commentedAt = commentedAt;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSyncListsLastActivitiesImpl that = (TraktSyncListsLastActivitiesImpl) o;

		if (likedAt != null ? !likedAt.equals(that.likedAt) : that.likedAt != null) return false;
		if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
		return commentedAt != null ? commentedAt.equals(that.commentedAt) : that.commentedAt == null;
	}

	@Override
	public int hashCode() {
		int result = likedAt != null ? likedAt.hashCode() : 0;
		result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
		result = 31 * result + (commentedAt != null ? commentedAt.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSyncListsLastActivities{" + "likedAt=" + likedAt + ", updatedAt=" + updatedAt + ", commentedAt=" + commentedAt + '}';
	}
}
