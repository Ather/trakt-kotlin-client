package media.thehoard.thirdparty.api.trakt.objects.get.episodes;

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds;

public interface TraktEpisodeIds extends TraktDefaultIds {
	int getTrakt();

	void setTrakt(int trakt);

	TraktEpisodeIds withTrakt(int trakt);

	Integer getTvdb();

	void setTvdb(Integer tvdb);

	TraktEpisodeIds withTvdb(Integer tvdb);

	String getImdb();

	void setImdb(String imdb);

	TraktEpisodeIds withImdb(String imdb);

	Integer getTmdb();

	void setTmdb(Integer tmdb);

	TraktEpisodeIds withTmdb(Integer tmdb);
}
