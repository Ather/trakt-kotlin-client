package media.thehoard.thirdparty.api.trakt.objects.get.people;

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds;
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonIdsImpl;

public interface TraktPersonIds extends TraktDefaultIds {
	int getTrakt();

	void setTrakt(int trakt);

	TraktPersonIdsImpl withTrakt(int trakt);

	String getSlug();

	void setSlug(String slug);

	TraktPersonIdsImpl withSlug(String slug);

	String getImdb();

	void setImdb(String imdb);

	TraktPersonIdsImpl withImdb(String imdb);

	Integer getTmdb();

	void setTmdb(Integer tmdb);

	TraktPersonIdsImpl withTmdb(Integer tmdb);
}
