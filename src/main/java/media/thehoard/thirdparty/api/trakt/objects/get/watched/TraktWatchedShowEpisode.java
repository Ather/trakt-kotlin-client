package media.thehoard.thirdparty.api.trakt.objects.get.watched;

import java.time.Instant;
import java.util.Date;

public interface TraktWatchedShowEpisode {
	Integer getNumber();

	void setNumber(Integer number);

	TraktWatchedShowEpisode withNumber(Integer number);

	Integer getPlays();

	void setPlays(Integer plays);

	TraktWatchedShowEpisode withPlays(Integer plays);

	Instant getLastWatchedAt();

	void setLastWatchedAt(Instant lastWatchedAt);

	TraktWatchedShowEpisode withLastWatchedAt(Instant lastWatchedAt);
}
