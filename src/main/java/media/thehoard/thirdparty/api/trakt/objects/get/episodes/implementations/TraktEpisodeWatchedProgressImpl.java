package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeWatchedProgress;

import java.util.Date;

public class TraktEpisodeWatchedProgressImpl implements TraktEpisodeWatchedProgress {
	private Integer number;
	private Boolean completed;

	@SerializedName("last_watched_at")
	private Date lastWatchedAt;

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktEpisodeWatchedProgress withNumber(Integer number) {
		this.number = number;
		return this;
	}

	@Override
	public Boolean getCompleted() {
		return completed;
	}

	@Override
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	@Override
	public TraktEpisodeWatchedProgress withCompleted(Boolean completed) {
		this.completed = completed;
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
	public TraktEpisodeWatchedProgress withLastWatchedAt(Date lastWatchedAt) {
		this.lastWatchedAt = lastWatchedAt;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktEpisodeWatchedProgressImpl that = (TraktEpisodeWatchedProgressImpl) o;

		return (number != null ? number.equals(that.number) : that.number == null) && (completed != null ? completed
				.equals(that.completed) : that.completed == null) && (lastWatchedAt != null ? lastWatchedAt
				.equals(that.lastWatchedAt) : that.lastWatchedAt == null);
	}

	@Override
	public int hashCode() {
		int result = number != null ? number.hashCode() : 0;
		result = 31 * result + (completed != null ? completed.hashCode() : 0);
		result = 31 * result + (lastWatchedAt != null ? lastWatchedAt.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktEpisodeWatchedProgress{" + "number=" + number + ", completed=" + completed + ", lastWatchedAt=" + lastWatchedAt + '}';
	}
}
