package media.thehoard.thirdparty.api.trakt.objects.get.seasons;

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds;

public interface TraktSeasonIds extends TraktDefaultIds {
	int getTrakt();

	void setTrakt(int trakt);

	TraktSeasonIds withTrakt(int trakt);

	Integer getTvdb();

	void setTvdb(Integer tvdb);

	TraktSeasonIds withTvdb(Integer tvdb);

	Integer getTmdb();

	void setTmdb(Integer tmdb);

	TraktSeasonIds withTmdb(Integer tmdb);
}
