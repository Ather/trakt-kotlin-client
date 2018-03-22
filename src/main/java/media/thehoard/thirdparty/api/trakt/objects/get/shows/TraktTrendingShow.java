package media.thehoard.thirdparty.api.trakt.objects.get.shows;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

public interface TraktTrendingShow extends TraktShow<TraktTrendingShow> {
	Integer getWatchers();

	void setWatchers(Integer watchers);

	TraktTrendingShow withWatchers(Integer watchers);

	TraktShow getShow();

	void setShow(TraktShowImpl show);

	TraktTrendingShow withShow(TraktShowImpl show);
}
