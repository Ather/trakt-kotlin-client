package media.thehoard.thirdparty.api.trakt.objects.get.watched;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.util.Date;
import java.util.List;

public interface TraktWatchedShow {
	Integer getPlays();

	void setPlays(Integer plays);

	TraktWatchedShow withPlays(Integer plays);

	Date getLastWatchedAt();

	void setLastWatchedAt(Date lastWatchedAt);

	TraktWatchedShow withLastWatchedAt(Date lastWatchedAt);

	TraktShowImpl getShow();

	void setShow(TraktShowImpl show);

	TraktWatchedShow withShow(TraktShowImpl show);

	List<TraktWatchedShowSeason> getSeasons();

	void setSeasons(List<TraktWatchedShowSeason> seasons);

	TraktWatchedShow withSeasons(List<TraktWatchedShowSeason> seasons);
}
