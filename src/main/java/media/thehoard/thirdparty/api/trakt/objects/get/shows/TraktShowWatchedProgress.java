package media.thehoard.thirdparty.api.trakt.objects.get.shows;

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonWatchedProgress;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonWatchedProgressImpl;

import java.util.Date;
import java.util.List;

public interface TraktShowWatchedProgress extends TraktShowProgress<TraktShowWatchedProgress> {
	Date getLastWatchedAt();

	void setLastWatchedAt(Date lastWatchedAt);

	TraktShowWatchedProgress withLastWatchedAt(Date lastWatchedAt);

	List<TraktSeasonWatchedProgressImpl> getSeasons();

	void setSeasons(List<TraktSeasonWatchedProgressImpl> seasons);

	TraktShowWatchedProgress withSeasons(List<TraktSeasonWatchedProgressImpl> seasons);
}
