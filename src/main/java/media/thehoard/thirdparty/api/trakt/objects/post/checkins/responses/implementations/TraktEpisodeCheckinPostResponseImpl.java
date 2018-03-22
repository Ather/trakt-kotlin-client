package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses.TraktEpisodeCheckinPostResponse;

import java.util.Date;

public class TraktEpisodeCheckinPostResponseImpl implements TraktEpisodeCheckinPostResponse {
	private long id;
	@SerializedName("watched_at")
	private Date watchedAt;
	private TraktSharingImpl sharing;

	private TraktEpisodeImpl episode;
	private TraktShowImpl show;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public TraktEpisodeCheckinPostResponse withId(long id) {
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
	public TraktEpisodeCheckinPostResponse withWatchedAt(Date watchedAt) {
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
	public TraktEpisodeCheckinPostResponse withSharing(TraktSharingImpl sharing) {
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
	public TraktEpisodeCheckinPostResponse withEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
		return this;
	}

	@Override
	public TraktShowImpl getShow() {
		return show;
	}

	@Override
	public void setShow(TraktShowImpl show) {
		this.show = show;
	}

	@Override
	public TraktEpisodeCheckinPostResponse withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktEpisodeCheckinPostResponseImpl that = (TraktEpisodeCheckinPostResponseImpl) o;

		if (id != that.id) return false;
		if (watchedAt != null ? !watchedAt.equals(that.watchedAt) : that.watchedAt != null) return false;
		if (sharing != null ? !sharing.equals(that.sharing) : that.sharing != null) return false;
		if (episode != null ? !episode.equals(that.episode) : that.episode != null) return false;
		return show != null ? show.equals(that.show) : that.show == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (watchedAt != null ? watchedAt.hashCode() : 0);
		result = 31 * result + (sharing != null ? sharing.hashCode() : 0);
		result = 31 * result + (episode != null ? episode.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktEpisodeCheckinPostResponse{" + "id=" + id + ", watchedAt=" + watchedAt + ", sharing=" + sharing + ", episode=" + episode + ", show=" + show + '}';
	}
}
