package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktCheckinPostResponse;

import java.util.Date;

public class TraktMovieCheckinPostResponseImpl implements TraktCheckinPostResponse<TraktMovieCheckinPostResponseImpl> {
	private long id;
	@SerializedName("watched_at")
	private Date watchedAt;
	private TraktSharingImpl sharing;

	private TraktMovieImpl movie;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public TraktMovieCheckinPostResponseImpl withId(long id) {
		this.id = id;
		return this;
	}

	@Override
	public Date getWatchedAt() {
		return watchedAt;
	}

	@Override
	public void setWatchedAt(Date watchedAt) {
		this.watchedAt = watchedAt;
	}

	@Override
	public TraktMovieCheckinPostResponseImpl withWatchedAt(Date watchedAt) {
		this.watchedAt = watchedAt;
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
	public TraktMovieCheckinPostResponseImpl withSharing(TraktSharingImpl sharing) {
		this.sharing = sharing;
		return this;
	}

	public TraktMovieImpl getMovie() {
		return movie;
	}

	public void setMovie(TraktMovieImpl movie) {
		this.movie = movie;
	}

	public TraktMovieCheckinPostResponseImpl withMovie(TraktMovieImpl movie) {
		this.movie = movie;
		return this;
	}
}
