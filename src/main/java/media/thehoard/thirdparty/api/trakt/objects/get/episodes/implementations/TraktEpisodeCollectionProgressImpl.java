package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeCollectionProgress;

import java.time.Instant;
import java.util.Date;

public class TraktEpisodeCollectionProgressImpl implements TraktEpisodeCollectionProgress {
	private Integer number;
	private Boolean completed;

	@SerializedName("collected_at")
	private Instant collectedAt;

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktEpisodeCollectionProgress withNumber(Integer number) {
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
	public TraktEpisodeCollectionProgress withCompleted(Boolean completed) {
		this.completed = completed;
		return this;
	}

	@Override
	public Instant getCollectedAt() {
		return collectedAt;
	}

	@Override
	public void setCollectedAt(Instant collectedAt) {
		this.collectedAt = collectedAt;
	}

	@Override
	public TraktEpisodeCollectionProgress withCollectedAt(Instant collectedAt) {
		this.collectedAt = collectedAt;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktEpisodeCollectionProgressImpl that = (TraktEpisodeCollectionProgressImpl) o;

		return (number != null ? number.equals(that.number) : that.number == null) && (completed != null ? completed
				.equals(that.completed) : that.completed == null) && (collectedAt != null ? collectedAt
				.equals(that.collectedAt) : that.collectedAt == null);
	}

	@Override
	public int hashCode() {
		int result = number != null ? number.hashCode() : 0;
		result = 31 * result + (completed != null ? completed.hashCode() : 0);
		result = 31 * result + (collectedAt != null ? collectedAt.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktEpisodeCollectionProgress{" + "number=" + number + ", completed=" + completed + ", collectedAt=" + collectedAt + '}';
	}
}
