package media.thehoard.thirdparty.api.trakt.objects.get.collections;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl;

import java.util.Date;

public interface TraktCollectionShowEpisode {
	Integer getNumber();

	void setNumber(Integer number);

	TraktCollectionShowEpisode withNumber(Integer number);

	Date getCollectedAt();

	void setCollectedAt(Date collectedAt);

	TraktCollectionShowEpisode withCollectedAt(Date collectedAt);

	TraktMetadataImpl getMetadata();

	void setMetadata(TraktMetadataImpl metadata);

	TraktCollectionShowEpisode withMetadata(TraktMetadataImpl metadata);
}
