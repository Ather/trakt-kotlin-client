package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktCommentPost;
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktEpisodeCommentPost;

public class TraktEpisodeCommentPostImpl implements TraktEpisodeCommentPost {
	private String comment;
	private Boolean spoiler;
	private TraktSharingImpl sharing;

	private TraktEpisodeImpl episode;

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public TraktEpisodeCommentPostImpl withComment(String comment) {
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
	public TraktEpisodeCommentPostImpl withSpoiler(Boolean spoiler) {
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
	public TraktEpisodeCommentPostImpl withSharing(TraktSharingImpl sharing) {
		this.sharing = sharing;
		return this;
	}

	@Override
	public TraktEpisodeImpl getEpisode() {
		return episode;
	}

	@Override
	public void setEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
	}

	@Override
	public TraktEpisodeCommentPost withEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktEpisodeCommentPostImpl that = (TraktEpisodeCommentPostImpl) o;

		if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
		if (spoiler != null ? !spoiler.equals(that.spoiler) : that.spoiler != null) return false;
		if (sharing != null ? !sharing.equals(that.sharing) : that.sharing != null) return false;
		return episode != null ? episode.equals(that.episode) : that.episode == null;
	}

	@Override
	public int hashCode() {
		int result = comment != null ? comment.hashCode() : 0;
		result = 31 * result + (spoiler != null ? spoiler.hashCode() : 0);
		result = 31 * result + (sharing != null ? sharing.hashCode() : 0);
		result = 31 * result + (episode != null ? episode.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktEpisodeCommentPost{" + "comment='" + comment + '\'' + ", spoiler=" + spoiler + ", sharing=" + sharing + ", episode=" + episode + '}';
	}
}
