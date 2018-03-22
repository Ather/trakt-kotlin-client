package media.thehoard.thirdparty.api.trakt.objects.get.seasons;

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonIdsImpl;

public interface TraktSeason<T extends TraktSeason<T>> {
	Integer getNumber();

	void setNumber(Integer number);

	T withNumber(Integer number);

	TraktSeasonIds getIds();

	void setIds(TraktSeasonIdsImpl ids);

	T withIds(TraktSeasonIdsImpl ids);
}
