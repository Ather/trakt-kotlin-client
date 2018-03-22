package media.thehoard.thirdparty.api.trakt.objects.get.shows;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl;

public interface TraktShow<T extends TraktShow<T>> {
	String getTitle();

	void setTitle(String title);

	T withTitle(String title);

	Integer getYear();

	void setYear(Integer year);

	T withYear(Integer year);

	TraktShowIdsImpl getIds();

	void setIds(TraktShowIdsImpl ids);

	T withIds(TraktShowIdsImpl ids);
}
