package media.thehoard.thirdparty.api.trakt.objects.get.episodes;

import java.time.Instant;
import java.util.Date;

public interface TraktEpisodeCollectionProgress extends TraktEpisodeProgress<TraktEpisodeCollectionProgress> {
	Instant getCollectedAt();

	void setCollectedAt(Instant collectedAt);

	TraktEpisodeCollectionProgress withCollectedAt(Instant collectedAt);
}
