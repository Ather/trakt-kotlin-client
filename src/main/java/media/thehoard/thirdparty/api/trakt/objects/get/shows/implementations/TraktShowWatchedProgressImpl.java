package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonWatchedProgressImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowWatchedProgress;

import java.util.Date;
import java.util.List;

public class TraktShowWatchedProgressImpl implements TraktShowWatchedProgress {
	private Integer aired;
	private Integer completed;
	@SerializedName("hidden_seasons")
	private List<TraktSeasonImpl> hiddenSeasons;
	@SerializedName("next_episode")
	private TraktEpisodeImpl nextEpisode;
	@SerializedName("last_episode")
	private TraktEpisodeImpl lastEpisode;

	@SerializedName("last_watched_at")
	private Date lastWatchedAt;
	private List<TraktSeasonWatchedProgressImpl> seasons;

	@Override
	public Integer getAired() {
		return aired;
	}

	@Override
	public void setAired(Integer aired) {
		this.aired = aired;
	}

	@Override
	public TraktShowWatchedProgressImpl withAired(Integer aired) {
		this.aired = aired;
		return this;
	}

	@Override
	public Integer getCompleted() {
		return completed;
	}

	@Override
	public void setCompleted(Integer completed) {
		this.completed = completed;
	}

	@Override
	public TraktShowWatchedProgressImpl withCompleted(Integer completed) {
		this.completed = completed;
		return this;
	}

	@Override
	public List<TraktSeasonImpl> getHiddenSeasons() {
		return hiddenSeasons;
	}

	@Override
	public void setHiddenSeasons(List<TraktSeasonImpl> hiddenSeasons) {
		this.hiddenSeasons = hiddenSeasons;
	}

	@Override
	public TraktShowWatchedProgressImpl withHiddenSeasons(List<TraktSeasonImpl> hiddenSeasons) {
		this.hiddenSeasons = hiddenSeasons;
		return this;
	}

	@Override
	public TraktEpisode getNextEpisode() {
		return nextEpisode;
	}

	@Override
	public void setNextEpisode(TraktEpisodeImpl nextEpisode) {
		this.nextEpisode = nextEpisode;
	}

	@Override
	public TraktShowWatchedProgressImpl withNextEpisode(TraktEpisodeImpl nextEpisode) {
		this.nextEpisode = nextEpisode;
		return this;
	}

	@Override
	public TraktEpisode getLastEpisode() {
		return lastEpisode;
	}

	@Override
	public void setLastEpisode(TraktEpisodeImpl lastEpisode) {
		this.lastEpisode = lastEpisode;
	}

	@Override
	public TraktShowWatchedProgressImpl withLastEpisode(TraktEpisodeImpl lastEpisode) {
		this.lastEpisode = lastEpisode;
		return this;
	}

	@Override
	public Date getLastWatchedAt() {
		return lastWatchedAt;
	}

	@Override
	public void setLastWatchedAt(Date lastWatchedAt) {
		this.lastWatchedAt = lastWatchedAt;
	}

	@Override
	public TraktShowWatchedProgress withLastWatchedAt(Date lastWatchedAt) {
		this.lastWatchedAt = lastWatchedAt;
		return this;
	}

	@Override
	public List<TraktSeasonWatchedProgressImpl> getSeasons() {
		return seasons;
	}

	@Override
	public void setSeasons(List<TraktSeasonWatchedProgressImpl> seasons) {
		this.seasons = seasons;
	}

	@Override
	public TraktShowWatchedProgress withSeasons(List<TraktSeasonWatchedProgressImpl> seasons) {
		this.seasons = seasons;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktShowWatchedProgressImpl that = (TraktShowWatchedProgressImpl) o;

		return (aired != null ? aired.equals(that.aired) : that.aired == null) && (completed != null ? completed
				.equals(that.completed) : that.completed == null) && (hiddenSeasons != null ? hiddenSeasons
				.equals(that.hiddenSeasons) : that.hiddenSeasons == null) && (nextEpisode != null ? nextEpisode
				.equals(that.nextEpisode) : that.nextEpisode == null) && (lastEpisode != null ? lastEpisode
				.equals(that.lastEpisode) : that.lastEpisode == null) && (lastWatchedAt != null ? lastWatchedAt
				.equals(that.lastWatchedAt) : that.lastWatchedAt == null) && (seasons != null ? seasons
				.equals(that.seasons) : that.seasons == null);
	}

	@Override
	public int hashCode() {
		int result = aired != null ? aired.hashCode() : 0;
		result = 31 * result + (completed != null ? completed.hashCode() : 0);
		result = 31 * result + (hiddenSeasons != null ? hiddenSeasons.hashCode() : 0);
		result = 31 * result + (nextEpisode != null ? nextEpisode.hashCode() : 0);
		result = 31 * result + (lastEpisode != null ? lastEpisode.hashCode() : 0);
		result = 31 * result + (lastWatchedAt != null ? lastWatchedAt.hashCode() : 0);
		result = 31 * result + (seasons != null ? seasons.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktShowWatchedProgress{" + "aired=" + aired + ", completed=" + completed + ", hiddenSeasons=" + hiddenSeasons + ", nextEpisode=" + nextEpisode + ", lastEpisode=" + lastEpisode + ", lastWatchedAt=" + lastWatchedAt + ", seasons=" + seasons + '}';
	}
}
