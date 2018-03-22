package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds;
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils;

public class TraktEpisodeIdsImpl implements TraktEpisodeIds {
	private int trakt;
	private Integer tvdb;
	private String imdb;
	private Integer tmdb;

	@Override
	public boolean hasAnyId() {
		return trakt > 0 || (tvdb != null ? tvdb.compareTo(0) : 0) > 0 || !TraktUtils.isNullOrEmpty(imdb) || (
				tmdb != null ? tmdb.compareTo(0) : 0) > 0;
	}

	@Override
	public String getBestId() {
		if (trakt > 0) return String.valueOf(trakt);

		if (tvdb != null && tvdb.compareTo(0) > 0) return tvdb.toString();

		if (!TraktUtils.isNullOrEmpty(imdb)) return imdb;

		if (tmdb != null && tmdb.compareTo(0) > 0) return tmdb.toString();

		return "";
	}


	@Override
	public int getTrakt() {
		return trakt;
	}

	@Override
	public void setTrakt(int trakt) {
		this.trakt = trakt;
	}

	@Override
	public TraktEpisodeIds withTrakt(int trakt) {
		this.trakt = trakt;
		return this;
	}

	@Override
	public Integer getTvdb() {
		return tvdb;
	}

	@Override
	public void setTvdb(Integer tvdb) {
		this.tvdb = tvdb;
	}

	@Override
	public TraktEpisodeIds withTvdb(Integer tvdb) {
		this.tvdb = tvdb;
		return this;
	}

	@Override
	public String getImdb() {
		return imdb;
	}

	@Override
	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	@Override
	public TraktEpisodeIds withImdb(String imdb) {
		this.imdb = imdb;
		return this;
	}

	@Override
	public Integer getTmdb() {
		return tmdb;
	}

	@Override
	public void setTmdb(Integer tmdb) {
		this.tmdb = tmdb;
	}

	@Override
	public TraktEpisodeIds withTmdb(Integer tmdb) {
		this.tmdb = tmdb;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktEpisodeIdsImpl that = (TraktEpisodeIdsImpl) o;

		return trakt == that.trakt && (tvdb != null ? tvdb.equals(that.tvdb) : that.tvdb == null) && (imdb != null
				? imdb.equals(that.imdb) : that.imdb == null) && (tmdb != null ? tmdb.equals(that.tmdb)
				: that.tmdb == null);
	}

	@Override
	public int hashCode() {
		int result = trakt;
		result = 31 * result + (tvdb != null ? tvdb.hashCode() : 0);
		result = 31 * result + (imdb != null ? imdb.hashCode() : 0);
		result = 31 * result + (tmdb != null ? tmdb.hashCode() : 0);
		return result;
	}
}
