package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktUserLikeType;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserLikeItem;
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList;

import java.time.Instant;

public class TraktUserLikeItemImpl implements media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserLikeItem {
	@SerializedName("liked_at")
	private Instant likedAt;
	private TraktUserLikeType type;
	private TraktCommentImpl comment;
	private TraktList list;

	@Override
	public Instant getLikedAt() {
		return likedAt;
	}

	@Override
	public void setLikedAt(Instant likedAt) {
		this.likedAt = likedAt;
	}

	@Override
	public TraktUserLikeItem withLikedAt(Instant likedAt) {
		this.likedAt = likedAt;
		return this;
	}

	@Override
	public TraktUserLikeType getType() {
		return type;
	}

	@Override
	public void setType(TraktUserLikeType type) {
		this.type = type;
	}

	@Override
	public TraktUserLikeItem withType(TraktUserLikeType type) {
		this.type = type;
		return this;
	}

	@Override
	public TraktCommentImpl getComment() {
		return comment;
	}

	@Override
	public void setComment(TraktCommentImpl comment) {
		this.comment = comment;
	}

	@Override
	public TraktUserLikeItem withComment(TraktCommentImpl comment) {
		this.comment = comment;
		return this;
	}

	@Override
	public TraktList getList() {
		return list;
	}

	@Override
	public void setList(TraktList list) {
		this.list = list;
	}

	@Override
	public TraktUserLikeItem withList(TraktList list) {
		this.list = list;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserLikeItemImpl that = (TraktUserLikeItemImpl) o;

		if (likedAt != null ? !likedAt.equals(that.likedAt) : that.likedAt != null) return false;
		if (type != that.type) return false;
		if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
		return list != null ? list.equals(that.list) : that.list == null;
	}

	@Override
	public int hashCode() {
		int result = likedAt != null ? likedAt.hashCode() : 0;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (comment != null ? comment.hashCode() : 0);
		result = 31 * result + (list != null ? list.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserLikeItem{" + "likedAt=" + likedAt + ", type=" + type + ", comment=" + comment + ", list=" + list + '}';
	}
}
