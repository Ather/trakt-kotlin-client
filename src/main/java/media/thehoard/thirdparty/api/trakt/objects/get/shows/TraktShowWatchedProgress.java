package media.thehoard.thirdparty.api.trakt.objects.get.shows;

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonWatchedProgressImpl;

import java.time.Instant;
import java.util.List;

public interface TraktShowWatchedProgress extends TraktShowProgress<TraktShowWatchedProgress> {
	Instant getLastWatchedAt();

	void setLastWatchedAt(Instant lastWatchedAt);

	TraktShowWatchedProgress withLastWatchedAt(Instant lastWatchedAt);

	List<TraktSeasonWatchedProgressImpl> getSeasons();

	void setSeasons(List<TraktSeasonWatchedProgressImpl> seasons);

	TraktShowWatchedProgress withSeasons(List<TraktSeasonWatchedProgressImpl> seasons);
}
