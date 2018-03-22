package media.thehoard.thirdparty.api.trakt.objects.get.episodes;

import java.util.Date;

public interface TraktEpisodeWatchedProgress extends TraktEpisodeProgress<TraktEpisodeWatchedProgress> {
	Date getLastWatchedAt();

	void setLastWatchedAt(Date lastWatchedAt);

	TraktEpisodeWatchedProgress withLastWatchedAt(Date lastWatchedAt);
}
