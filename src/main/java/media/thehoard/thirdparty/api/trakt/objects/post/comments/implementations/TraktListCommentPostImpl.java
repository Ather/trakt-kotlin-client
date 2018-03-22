package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktListCommentPost;

public class TraktListCommentPostImpl implements TraktListCommentPost {
	private String comment;
	private Boolean spoiler;
	private TraktSharingImpl sharing;

	private TraktListImpl list;

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public TraktListCommentPost withComment(String comment) {
		this.comment = comment;
		return this;
	}

	@Override
	public Boolean getSpoiler() {
		return spoiler;
	}

	@Override
	public void setSpoiler(Boolean spoiler) {
		this.spoiler = spoiler;
	}

	@Override
	public TraktListCommentPost withSpoiler(Boolean spoiler) {
		this.spoiler = spoiler;
		return this;
	}

	@Override
	public TraktSharingImpl getSharing() {
		return sharing;
	}

	@Override
	public void setSharing(TraktSharingImpl sharing) {
		this.sharing = sharing;
	}

	@Override
	public TraktListCommentPost withSharing(TraktSharingImpl sharing) {
		this.sharing = sharing;
		return this;
	}

	@Override
	public TraktListImpl getList() {
		return list;
	}

	@Override
	public void setList(TraktListImpl list) {
		this.list = list;
	}

	@Override
	public TraktListCommentPost withList(TraktListImpl list) {
		this.list = list;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktListCommentPostImpl that = (TraktListCommentPostImpl) o;

		if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
		if (spoiler != null ? !spoiler.equals(that.spoiler) : that.spoiler != null) return false;
		if (sharing != null ? !sharing.equals(that.sharing) : that.sharing != null) return false;
		return list != null ? list.equals(that.list) : that.list == null;
	}

	@Override
	public int hashCode() {
		int result = comment != null ? comment.hashCode() : 0;
		result = 31 * result + (spoiler != null ? spoiler.hashCode() : 0);
		result = 31 * result + (sharing != null ? sharing.hashCode() : 0);
		result = 31 * result + (list != null ? list.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktListCommentPost{" + "comment='" + comment + '\'' + ", spoiler=" + spoiler + ", sharing=" + sharing + ", list=" + list + '}';
	}
}
