package media.thehoard.thirdparty.api.trakt.objects.get.movies;

import media.thehoard.thirdparty.api.trakt.core.TraktDefaultIds;

public interface TraktMovieIds extends TraktDefaultIds {
	int getTrakt();

	void setTrakt(int trakt);

	TraktMovieIds withTrakt(int trakt);

	String getSlug();

	void setSlug(String slug);

	TraktMovieIds withSlug(String slug);

	String getImdb();

	void setImdb(String imdb);

	TraktMovieIds withImdb(String imdb);

	Integer getTmdb();

	void setTmdb(Integer tmdb);

	TraktMovieIds withTmdb(Integer tmdb);
}
