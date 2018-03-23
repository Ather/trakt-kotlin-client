package media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShowEpisode;

import java.time.Instant;
import java.util.Date;

public class TraktWatchedShowEpisodeImpl implements TraktWatchedShowEpisode {
	private Integer number;
	private Integer plays;
	@SerializedName("last_watched_at")
	private Instant lastWatchedAt;

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktWatchedShowEpisode withNumber(Integer number) {
		this.number = number;
		return this;
	}

	@Override
	public Integer getPlays() {
		return plays;
	}

	@Override
	public void setPlays(Integer plays) {
		this.plays = plays;
	}

	@Override
	public TraktWatchedShowEpisode withPlays(Integer plays) {
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
	public TraktWatchedShowEpisode withLastWatchedAt(Instant lastWatchedAt) {
		this.lastWatchedAt = lastWatchedAt;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktWatchedShowEpisodeImpl that = (TraktWatchedShowEpisodeImpl) o;

		if (number != null ? !number.equals(that.number) : that.number != null) return false;
		if (plays != null ? !plays.equals(that.plays) : that.plays != null) return false;
		return lastWatchedAt != null ? lastWatchedAt.equals(that.lastWatchedAt) : that.lastWatchedAt == null;
	}

	@Override
	public int hashCode() {
		int result = number != null ? number.hashCode() : 0;
		result = 31 * result + (plays != null ? plays.hashCode() : 0);
		result = 31 * result + (lastWatchedAt != null ? lastWatchedAt.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktWatchedShowEpisode{" + "number=" + number + ", plays=" + plays + ", lastWatchedAt=" + lastWatchedAt + '}';
	}
}
