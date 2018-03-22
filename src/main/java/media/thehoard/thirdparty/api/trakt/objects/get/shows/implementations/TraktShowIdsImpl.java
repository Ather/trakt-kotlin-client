package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktIdsImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowIds;
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils;

public class TraktShowIdsImpl implements TraktShowIds {
	private int trakt;
	private String slug;
	private Integer tvdb;
	private String imdb;
	private Integer tmdb;

	@Override
	public int getTrakt() {
		return trakt;
	}

	@Override
	public void setTrakt(int trakt) {
		this.trakt = trakt;
	}

	@Override
	public TraktShowIdsImpl withTrakt(int trakt) {
		this.trakt = trakt;
		return this;
	}

	@Override
	public String getSlug() {
		return slug;
	}

	@Override
	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Override
	public TraktShowIdsImpl withSlug(String slug) {
		this.slug = slug;
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
	public TraktShowIdsImpl withTvdb(Integer tvdb) {
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
	public TraktShowIdsImpl withImdb(String imdb) {
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
	public TraktShowIdsImpl withTmdb(Integer tmdb) {
		this.tmdb = tmdb;
		return this;
	}

	@Override
	public boolean hasAnyId() {
		return trakt > 0 || (tvdb != null ? tvdb.compareTo(0) : 0) > 0 || !TraktUtils.isNullOrEmpty(slug) || !TraktUtils
				.isNullOrEmpty(imdb) || (tmdb != null ? tmdb.compareTo(0) : 0) > 0;
	}

	@Override
	public String getBestId() {
		if (trakt > 0) return String.valueOf(trakt);

		if (!TraktUtils.isNullOrEmpty(slug)) return slug;

		if (tvdb != null && tvdb.compareTo(0) > 0) return tvdb.toString();

		if (!TraktUtils.isNullOrEmpty(imdb)) return imdb;

		if (tmdb != null && tmdb.compareTo(0) > 0) return tmdb.toString();

		return "";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktShowIdsImpl traktIds = (TraktShowIdsImpl) o;

		return trakt == traktIds.trakt && (slug != null ? slug.equals(traktIds.slug) : traktIds.slug == null) && (
				tvdb != null ? tvdb.equals(traktIds.tvdb) : traktIds.tvdb == null) && (imdb != null ? imdb
				.equals(traktIds.imdb) : traktIds.imdb == null) && (tmdb != null ? tmdb.equals(traktIds.tmdb)
				: traktIds.tmdb == null);
	}

	@Override
	public int hashCode() {
		int result = trakt;
		result = 31 * result + (slug != null ? slug.hashCode() : 0);
		result = 31 * result + (tvdb != null ? tvdb.hashCode() : 0);
		result = 31 * result + (imdb != null ? imdb.hashCode() : 0);
		result = 31 * result + (tmdb != null ? tmdb.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktShowIds{" + "trakt=" + trakt + ", slug='" + slug + '\'' + ", tvdb=" + tvdb + ", imdb='" + imdb + '\'' + ", tmdb=" + tmdb + '}';
	}
}
