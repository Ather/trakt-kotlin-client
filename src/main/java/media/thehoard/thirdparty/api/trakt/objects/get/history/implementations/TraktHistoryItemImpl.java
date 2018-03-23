package media.thehoard.thirdparty.api.trakt.objects.get.history.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktHistoryActionType;
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.history.TraktHistoryItem;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.time.Instant;

public class TraktHistoryItemImpl implements TraktHistoryItem {
	private long id;
	@SerializedName("watched_at")
	private Instant watchedAt;
	private TraktHistoryActionType action;
	private TraktSyncItemType type;
	private TraktMovieImpl movie;
	private TraktShowImpl show;
	private TraktSeasonImpl season;
	private TraktEpisodeImpl episode;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public TraktHistoryItem withId(long id) {
		this.id = id;
		return this;
	}

	@Override
	public Instant getWatchedAt() {
		return watchedAt;
	}

	@Override
	public void setWatchedAt(Instant watchedAt) {
		this.watchedAt = watchedAt;
	}

	@Override
	public TraktHistoryItem withWatchedAt(Instant watchedAt) {
		this.watchedAt = watchedAt;
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
	public TraktHistoryItem withAction(TraktHistoryActionType action) {
		this.action = action;
		return this;
	}

	@Override
	public TraktSyncItemType getType() {
		return type;
	}

	@Override
	public void setType(TraktSyncItemType type) {
		this.type = type;
	}

	@Override
	public TraktHistoryItem withType(TraktSyncItemType type) {
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
	public TraktHistoryItem withMovie(TraktMovieImpl movie) {
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
	public TraktHistoryItem withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public TraktSeasonImpl getSeason() {
		return season;
	}

	@Override
	public void setSeason(TraktSeasonImpl season) {
		this.season = season;
	}

	@Override
	public TraktHistoryItem withSeason(TraktSeasonImpl season) {
		this.season = season;
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
	public TraktHistoryItem withEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktHistoryItemImpl that = (TraktHistoryItemImpl) o;

		if (id != that.id) return false;
		if (watchedAt != null ? !watchedAt.equals(that.watchedAt) : that.watchedAt != null) return false;
		if (action != that.action) return false;
		if (type != that.type) return false;
		if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
		if (show != null ? !show.equals(that.show) : that.show != null) return false;
		if (season != null ? !season.equals(that.season) : that.season != null) return false;
		return episode != null ? episode.equals(that.episode) : that.episode == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (watchedAt != null ? watchedAt.hashCode() : 0);
		result = 31 * result + (action != null ? action.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		result = 31 * result + (season != null ? season.hashCode() : 0);
		result = 31 * result + (episode != null ? episode.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktHistoryItem{" + "id=" + id + ", watchedAt=" + watchedAt + ", action=" + action + ", type=" + type + ", movie=" + movie + ", show=" + show + ", season=" + season + ", episode=" + episode + '}';
	}
}
