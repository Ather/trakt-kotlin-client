package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktHistoryActionType;
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserWatchingItem;

import java.time.Instant;

public class TraktUserWatchingItemImpl
		implements media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserWatchingItem {
	@SerializedName("started_at")
	private Instant startedAt;
	@SerializedName("expires_at")
	private Instant expiresAt;
	private TraktHistoryActionType action;
	private TraktSyncType type;
	private TraktMovieImpl movie;
	private TraktShowImpl show;
	private TraktEpisodeImpl episode;

	@Override
	public Instant getStartedAt() {
		return startedAt;
	}

	@Override
	public void setStartedAt(Instant startedAt) {
		this.startedAt = startedAt;
	}

	@Override
	public TraktUserWatchingItem withStartedAt(Instant startedAt) {
		this.startedAt = startedAt;
		return this;
	}

	@Override
	public Instant getExpiresAt() {
		return expiresAt;
	}

	@Override
	public void setExpiresAt(Instant expiresAt) {
		this.expiresAt = expiresAt;
	}

	@Override
	public TraktUserWatchingItem withExpiresAt(Instant expiresAt) {
		this.expiresAt = expiresAt;
		return this;
	}

	@Override
	public TraktHistoryActionType getAction() {
		return action;
	}

	@Override
	public void setAction(TraktHistoryActionType action) {
		this.action = action;
	}

	@Override
	public TraktUserWatchingItem withAction(TraktHistoryActionType action) {
		this.action = action;
		return this;
	}

	@Override
	public TraktSyncType getType() {
		return type;
	}

	@Override
	public void setType(TraktSyncType type) {
		this.type = type;
	}

	@Override
	public TraktUserWatchingItem withType(TraktSyncType type) {
		this.type = type;
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
	public TraktUserWatchingItem withMovie(TraktMovieImpl movie) {
		this.movie = movie;
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
	public TraktUserWatchingItem withShow(TraktShowImpl show) {
		this.show = show;
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
	public TraktUserWatchingItem withEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserWatchingItemImpl that = (TraktUserWatchingItemImpl) o;

		if (startedAt != null ? !startedAt.equals(that.startedAt) : that.startedAt != null) return false;
		if (expiresAt != null ? !expiresAt.equals(that.expiresAt) : that.expiresAt != null) return false;
		if (action != that.action) return false;
		if (type != that.type) return false;
		if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
		if (show != null ? !show.equals(that.show) : that.show != null) return false;
		return episode != null ? episode.equals(that.episode) : that.episode == null;
	}

	@Override
	public int hashCode() {
		int result = startedAt != null ? startedAt.hashCode() : 0;
		result = 31 * result + (expiresAt != null ? expiresAt.hashCode() : 0);
		result = 31 * result + (action != null ? action.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		result = 31 * result + (episode != null ? episode.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserWatchingItem{" + "startedAt=" + startedAt + ", expiresAt=" + expiresAt + ", action=" + action + ", type=" + type + ", movie=" + movie + ", show=" + show + ", episode=" + episode + '}';
	}
}
