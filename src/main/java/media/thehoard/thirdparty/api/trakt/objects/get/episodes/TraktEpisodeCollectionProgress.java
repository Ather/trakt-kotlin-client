package media.thehoard.thirdparty.api.trakt.objects.get.episodes;

import java.util.Date;

public interface TraktEpisodeCollectionProgress extends TraktEpisodeProgress<TraktEpisodeCollectionProgress> {
	Date getCollectedAt();

	void setCollectedAt(Date collectedAt);

	TraktEpisodeCollectionProgress withCollectedAt(Date collectedAt);
}
