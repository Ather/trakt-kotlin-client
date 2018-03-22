package media.thehoard.thirdparty.api.trakt.objects.get.calendars;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds;

public interface TraktCalendarEpisode<T extends TraktCalendarEpisode<T>> {
	Integer getSeason();

	void setSeason(Integer season);

	T withSeason(Integer season);

	Integer getEpisodeNumber();

	void setEpisodeNumber(Integer number);

	T withEpisodeNumber(Integer number);

	String getEpisodeTitle();

	void setEpisodeTitle(String title);

	T withEpisodeTitle(String title);

	TraktEpisodeIds getEpisodeIds();

	void setEpisodeIds(TraktEpisodeIds ids);

	T withEpisodeIds(TraktEpisodeIds ids);
}
