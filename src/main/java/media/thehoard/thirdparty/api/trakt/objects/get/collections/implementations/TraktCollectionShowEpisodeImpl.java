package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowEpisode;

import java.util.Date;

public class TraktCollectionShowEpisodeImpl implements TraktCollectionShowEpisode {
	private Integer number;
	@SerializedName("collected_at")
	private Date collectedAt;
	//TODO Consider using Extended versions, this isn't explicitly included. (?extended = metadata)
	private TraktMetadataImpl metadata;

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktCollectionShowEpisode withNumber(Integer number) {
		this.number = number;
		return this;
	}

	@Override
	public Date getCollectedAt() {
		return collectedAt;
	}

	@Override
	public void setCollectedAt(Date collectedAt) {
		this.collectedAt = collectedAt;
	}

	@Override
	public TraktCollectionShowEpisode withCollectedAt(Date collectedAt) {
		this.collectedAt = collectedAt;
		return this;
	}

	@Override
	public TraktMetadataImpl getMetadata() {
		return metadata;
	}

	@Override
	public void setMetadata(TraktMetadataImpl metadata) {
		this.metadata = metadata;
	}

	@Override
	public TraktCollectionShowEpisode withMetadata(TraktMetadataImpl metadata) {
		this.metadata = metadata;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktCollectionShowEpisodeImpl that = (TraktCollectionShowEpisodeImpl) o;

		if (number != null ? !number.equals(that.number) : that.number != null) return false;
		if (collectedAt != null ? !collectedAt.equals(that.collectedAt) : that.collectedAt != null) return false;
		return metadata != null ? metadata.equals(that.metadata) : that.metadata == null;
	}

	@Override
	public int hashCode() {
		int result = number != null ? number.hashCode() : 0;
		result = 31 * result + (collectedAt != null ? collectedAt.hashCode() : 0);
		result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktCollectionShowEpisode{" + "number=" + number + ", collectedAt=" + collectedAt + ", metadata=" + metadata + '}';
	}
}
