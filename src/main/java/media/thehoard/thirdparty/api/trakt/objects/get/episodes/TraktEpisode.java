package media.thehoard.thirdparty.api.trakt.objects.get.episodes;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl;

public interface TraktEpisode<T extends TraktEpisode<T>> {
	Integer getSeason();

	void setSeason(Integer season);

	T withSeason(Integer season);

	Integer getNumber();

	void setNumber(Integer number);

	T withNumber(Integer number);

	String getTitle();

	void setTitle(String title);

	T withTitle(String title);

	TraktEpisodeIds getIds();

	void setIds(TraktEpisodeIdsImpl ids);

	T withIds(TraktEpisodeIdsImpl ids);
}
