package media.thehoard.thirdparty.api.trakt.objects.basic;

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds;

public interface TraktIds extends TraktDefaultIds {
	int getTrakt();

	void setTrakt(int trakt);

	String getSlug();

	void setSlug(String slug);

	Integer getTvdb();

	void setTvdb(Integer tvdb);

	String getImdb();

	void setImdb(String imdb);

	Integer getTmdb();

	void setTmdb(Integer tmdb);
}
