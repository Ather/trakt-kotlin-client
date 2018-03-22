package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktIds;
import media.thehoard.thirdparty.api.trakt.utils.TraktUtils;

public class TraktIdsImpl implements TraktIds {
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
	public String getSlug() {
		return slug;
	}

	@Override
	public void setSlug(String slug) {
		this.slug = slug;
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
	public String getImdb() {
		return imdb;
	}

	@Override
	public void setImdb(String imdb) {
		this.imdb = imdb;
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
}
