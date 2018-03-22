package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.implementations.TraktMovieCheckinPostImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktCommentPost;

public abstract class AbstractTraktCommentPost implements TraktCommentPost {
	private String comment;
	private Boolean spoiler;
	private TraktSharingImpl sharing;

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public TraktCommentPost withComment(String comment) {
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
	public TraktCommentPost withSpoiler(Boolean spoiler) {
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
	public TraktCommentPost withSharing(TraktSharingImpl sharing) {
		this.sharing = sharing;
		return this;
	}
}
