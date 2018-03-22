package media.thehoard.thirdparty.api.trakt.objects.get.people.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPersonIds;
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils;

public class TraktPersonIdsImpl implements TraktPersonIds {
	private int trakt;
	private String slug;
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
	public TraktPersonIdsImpl withTrakt(int trakt) {
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
	public TraktPersonIdsImpl withSlug(String slug) {
		this.slug = slug;
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
	public TraktPersonIdsImpl withImdb(String imdb) {
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
	public TraktPersonIdsImpl withTmdb(Integer tmdb) {
		this.tmdb = tmdb;
		return this;
	}

	@Override
	public boolean hasAnyId() {
		return trakt > 0 || !TraktUtils.isNullOrEmpty(slug) || !TraktUtils.isNullOrEmpty(imdb) || (tmdb != null ? tmdb
				.compareTo(0) : 0) > 0;
	}

	@Override
	public String getBestId() {
		if (trakt > 0) return String.valueOf(trakt);

		if (!TraktUtils.isNullOrEmpty(slug)) return slug;

		if (!TraktUtils.isNullOrEmpty(imdb)) return imdb;

		if (tmdb != null && tmdb.compareTo(0) > 0) return tmdb.toString();

		return "";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktPersonIdsImpl that = (TraktPersonIdsImpl) o;

		return trakt == that.trakt && (slug != null ? slug.equals(that.slug) : that.slug == null) && (imdb != null
				? imdb.equals(that.imdb) : that.imdb == null) && (tmdb != null ? tmdb.equals(that.tmdb)
				: that.tmdb == null);
	}

	@Override
	public int hashCode() {
		int result = trakt;
		result = 31 * result + (slug != null ? slug.hashCode() : 0);
		result = 31 * result + (imdb != null ? imdb.hashCode() : 0);
		result = 31 * result + (tmdb != null ? tmdb.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		String bestId = getBestId();
		return TraktUtils.isNullOrEmpty(bestId) ? bestId : "no valid id";
	}
}
