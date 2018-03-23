package media.thehoard.thirdparty.api.trakt.objects.get.watched;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.time.Instant;
import java.util.List;

public interface TraktWatchedShow {
	Integer getPlays();

	void setPlays(Integer plays);

	TraktWatchedShow withPlays(Integer plays);

	Instant getLastWatchedAt();

	void setLastWatchedAt(Instant lastWatchedAt);

	TraktWatchedShow withLastWatchedAt(Instant lastWatchedAt);

	TraktShowImpl getShow();

	void setShow(TraktShowImpl show);

	TraktWatchedShow withShow(TraktShowImpl show);

	List<TraktWatchedShowSeason> getSeasons();

	void setSeasons(List<TraktWatchedShowSeason> seasons);

	TraktWatchedShow withSeasons(List<TraktWatchedShowSeason> seasons);
}
