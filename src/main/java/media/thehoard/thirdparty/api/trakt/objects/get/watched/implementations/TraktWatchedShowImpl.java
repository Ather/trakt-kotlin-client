package media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShow;
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShowSeason;

import java.time.Instant;
import java.util.List;

public class TraktWatchedShowImpl implements TraktWatchedShow {
	private Integer plays;
	@SerializedName("last_watched_at")
	private Instant lastWatchedAt;
	private TraktShowImpl show;
	private List<TraktWatchedShowSeason> seasons;

	@Override
	public Integer getPlays() {
		return plays;
	}

	@Override
	public void setPlays(Integer plays) {
		this.plays = plays;
	}

	@Override
	public TraktWatchedShow withPlays(Integer plays) {
		this.plays = plays;
		return this;
	}

	@Override
	public Instant getLastWatchedAt() {
		return lastWatchedAt;
	}

	@Override
	public void setLastWatchedAt(Instant lastWatchedAt) {
		this.lastWatchedAt = lastWatchedAt;
	}

	@Override
	public TraktWatchedShow withLastWatchedAt(Instant lastWatchedAt) {
		this.lastWatchedAt = lastWatchedAt;
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
	public TraktWatchedShow withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public List<TraktWatchedShowSeason> getSeasons() {
		return seasons;
	}

	@Override
	public void setSeasons(List<TraktWatchedShowSeason> seasons) {
		this.seasons = seasons;
	}

	@Override
	public TraktWatchedShow withSeasons(List<TraktWatchedShowSeason> seasons) {
		this.seasons = seasons;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktWatchedShowImpl that = (TraktWatchedShowImpl) o;

		if (plays != null ? !plays.equals(that.plays) : that.plays != null) return false;
		if (lastWatchedAt != null ? !lastWatchedAt.equals(that.lastWatchedAt) : that.lastWatchedAt != null)
			return false;
		if (show != null ? !show.equals(that.show) : that.show != null) return false;
		return seasons != null ? seasons.equals(that.seasons) : that.seasons == null;
	}

	@Override
	public int hashCode() {
		int result = plays != null ? plays.hashCode() : 0;
		result = 31 * result + (lastWatchedAt != null ? lastWatchedAt.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		result = 31 * result + (seasons != null ? seasons.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktWatchedShow{" + "plays=" + plays + ", lastWatchedAt=" + lastWatchedAt + ", show=" + show + ", seasons=" + seasons + '}';
	}
}
