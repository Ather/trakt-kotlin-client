package media.thehoard.thirdparty.api.trakt.objects.get.collections;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.time.Instant;
import java.util.List;

public interface TraktCollectionShow extends TraktShow<TraktCollectionShow> {
	Instant getLastCollectedAt();

	void setLastCollectedAt(Instant lastCollectedAt);

	TraktCollectionShow withLastCollectedAt(Instant lastCollectedAt);

	TraktShowImpl getShow();

	void setShow(TraktShowImpl show);

	TraktCollectionShow withShow(TraktShowImpl show);

	List<TraktCollectionShowSeason> getSeasons();

	void setSeasons(List<TraktCollectionShowSeason> seasons);

	TraktCollectionShow withSeasons(List<TraktCollectionShowSeason> seasons);
}
