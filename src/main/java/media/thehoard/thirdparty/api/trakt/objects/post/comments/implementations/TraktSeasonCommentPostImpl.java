package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktCommentPost;

public class TraktSeasonCommentPostImpl implements TraktCommentPost<TraktSeasonCommentPostImpl> {
	private String comment;
	private Boolean spoiler;
	private TraktSharingImpl sharing;

	private TraktSeasonImpl season;

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public TraktSeasonCommentPostImpl withComment(String comment) {
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
	public TraktSeasonCommentPostImpl withSpoiler(Boolean spoiler) {
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
	public TraktSeasonCommentPostImpl withSharing(TraktSharingImpl sharing) {
		this.sharing = sharing;
		return this;
	}

	public TraktSeasonImpl getSeason() {
		return season;
	}

	public void setSeason(TraktSeasonImpl season) {
		this.season = season;
	}

	public TraktSeasonCommentPostImpl withSeason(TraktSeasonImpl season) {
		this.season = season;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSeasonCommentPostImpl that = (TraktSeasonCommentPostImpl) o;

		if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
		if (spoiler != null ? !spoiler.equals(that.spoiler) : that.spoiler != null) return false;
		if (sharing != null ? !sharing.equals(that.sharing) : that.sharing != null) return false;
		return season != null ? season.equals(that.season) : that.season == null;
	}

	@Override
	public int hashCode() {
		int result = comment != null ? comment.hashCode() : 0;
		result = 31 * result + (spoiler != null ? spoiler.hashCode() : 0);
		result = 31 * result + (sharing != null ? sharing.hashCode() : 0);
		result = 31 * result + (season != null ? season.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSeasonCommentPost{" + "comment='" + comment + '\'' + ", spoiler=" + spoiler + ", sharing=" + sharing + ", season=" + season + '}';
	}
}
