package media.thehoard.thirdparty.api.trakt.objects.get.shows;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

public interface TraktMostPWCShow extends TraktShow<TraktMostPWCShow> {
	Integer getWatcherCount();

	void setWatcherCount(Integer watcherCount);

	TraktMostPWCShow withWatcherCount(Integer watcherCount);

	Integer getPlayCount();

	void setPlayCount(Integer playCount);

	TraktMostPWCShow withPlayCount(Integer playCount);

	Integer getCollectedCount();

	void setCollectedCount(Integer collectedCount);

	TraktMostPWCShow withCollectedCount(Integer collectedCount);

	Integer getCollectorCount();

	void setCollectorCount(Integer collectorCount);

	TraktMostPWCShow withCollectorCount(Integer collectorCount);

	TraktShow getShow();

	void setShow(TraktShowImpl show);

	TraktMostPWCShow withShow(TraktShowImpl show);
}
