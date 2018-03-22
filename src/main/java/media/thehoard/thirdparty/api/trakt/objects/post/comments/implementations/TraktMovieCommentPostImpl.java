package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktMovieCommentPost;

public class TraktMovieCommentPostImpl implements TraktMovieCommentPost {
	private String comment;
	private Boolean spoiler;
	private TraktSharingImpl sharing;

	private TraktMovieImpl movie;

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public TraktMovieCommentPost withComment(String comment) {
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
	public TraktMovieCommentPost withSpoiler(Boolean spoiler) {
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
	public TraktMovieCommentPost withSharing(TraktSharingImpl sharing) {
		this.sharing = sharing;
		return this;
	}

	@Override
	public TraktMovieImpl getMovie() {
		return movie;
	}

	@Override
	public void setMovie(TraktMovieImpl movie) {
		this.movie = movie;
	}

	@Override
	public TraktMovieCommentPost withMovie(TraktMovieImpl movie) {
		this.movie = movie;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktMovieCommentPostImpl that = (TraktMovieCommentPostImpl) o;

		if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
		if (spoiler != null ? !spoiler.equals(that.spoiler) : that.spoiler != null) return false;
		if (sharing != null ? !sharing.equals(that.sharing) : that.sharing != null) return false;
		return movie != null ? movie.equals(that.movie) : that.movie == null;
	}

	@Override
	public int hashCode() {
		int result = comment != null ? comment.hashCode() : 0;
		result = 31 * result + (spoiler != null ? spoiler.hashCode() : 0);
		result = 31 * result + (sharing != null ? sharing.hashCode() : 0);
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktMovieCommentPost{" + "comment='" + comment + '\'' + ", spoiler=" + spoiler + ", sharing=" + sharing + ", movie=" + movie + '}';
	}
}
