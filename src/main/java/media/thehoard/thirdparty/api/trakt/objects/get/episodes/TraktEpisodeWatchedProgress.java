package media.thehoard.thirdparty.api.trakt.objects.get.episodes;

import java.time.Instant;
import java.util.Date;

public interface TraktEpisodeWatchedProgress extends TraktEpisodeProgress<TraktEpisodeWatchedProgress> {
	Instant getLastWatchedAt();

	void setLastWatchedAt(Instant lastWatchedAt);

	TraktEpisodeWatchedProgress withLastWatchedAt(Instant lastWatchedAt);
}
