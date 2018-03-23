package media.thehoard.thirdparty.api.trakt.objects.get.collections;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl;

import java.time.Instant;

public interface TraktCollectionShowEpisode {
	Integer getNumber();

	void setNumber(Integer number);

	TraktCollectionShowEpisode withNumber(Integer number);

	Instant getCollectedAt();

	void setCollectedAt(Instant collectedAt);

	TraktCollectionShowEpisode withCollectedAt(Instant collectedAt);

	TraktMetadataImpl getMetadata();

	void setMetadata(TraktMetadataImpl metadata);

	TraktCollectionShowEpisode withMetadata(TraktMetadataImpl metadata);
}
