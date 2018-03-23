package media.thehoard.thirdparty.api.trakt.objects.get.syncs.playback.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.syncs.playback.TraktSyncPlaybackProgressItem;

import java.time.Instant;

public class TraktSyncPlaybackProgressItemImpl implements TraktSyncPlaybackProgressItem {
	private int id;
	private Float progress;
	@SerializedName("pause_at")
	private Instant pausedAt;
	private TraktSyncType type;
	private TraktMovieImpl movie;
	private TraktEpisodeImpl episode;
	private TraktShowImpl show;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public TraktSyncPlaybackProgressItem withId(int id) {
		this.id = id;
		return this;
	}

	@Override
	public Float getProgress() {
		return progress;
	}

	@Override
	public void setProgress(Float progress) {
		this.progress = progress;
	}

	@Override
	public TraktSyncPlaybackProgressItem withProgress(Float progress) {
		this.progress = progress;
		return this;
	}

	@Override
	public Instant getPausedAt() {
		return pausedAt;
	}

	@Override
	public void setPausedAt(Instant pausedAt) {
		this.pausedAt = pausedAt;
	}

	@Override
	public TraktSyncPlaybackProgressItem withPausedAt(Instant pausedAt) {
		this.pausedAt = pausedAt;
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
	public TraktSyncPlaybackProgressItem withType(TraktSyncType type) {
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
	public TraktSyncPlaybackProgressItem withMovie(TraktMovieImpl movie) {
		this.movie = movie;
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
	public TraktSyncPlaybackProgressItem withEpisode(TraktEpisodeImpl episode) {
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
	public TraktSyncPlaybackProgressItem withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSyncPlaybackProgressItemImpl that = (TraktSyncPlaybackProgressItemImpl) o;

		if (id != that.id) return false;
		if (progress != null ? !progress.equals(that.progress) : that.progress != null) return false;
		if (pausedAt != null ? !pausedAt.equals(that.pausedAt) : that.pausedAt != null) return false;
		if (type != that.type) return false;
		if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
		if (episode != null ? !episode.equals(that.episode) : that.episode != null) return false;
		return show != null ? show.equals(that.show) : that.show == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (progress != null ? progress.hashCode() : 0);
		result = 31 * result + (pausedAt != null ? pausedAt.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		result = 31 * result + (episode != null ? episode.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSyncPlaybackProgressItem{" + "id=" + id + ", progress=" + progress + ", pausedAt=" + pausedAt + ", type=" + type + ", movie=" + movie + ", episode=" + episode + ", show=" + show + '}';
	}
}
