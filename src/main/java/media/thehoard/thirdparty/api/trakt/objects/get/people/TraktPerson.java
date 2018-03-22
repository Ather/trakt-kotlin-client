package media.thehoard.thirdparty.api.trakt.objects.get.people;

import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonIdsImpl;

public interface TraktPerson<T extends TraktPerson<T>> {
	String getName();

	void setName(String name);

	T withName(String name);

	TraktPersonIdsImpl getIds();

	void setIds(TraktPersonIdsImpl ids);

	T withIds(TraktPersonIdsImpl ids);
}
