package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonIds;

public class TraktSeasonIdsImpl implements TraktSeasonIds {
	private int trakt;
	private Integer tvdb;
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
	public TraktSeasonIds withTrakt(int trakt) {
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
	public TraktSeasonIds withTvdb(Integer tvdb) {
		this.tvdb = tvdb;
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
	public TraktSeasonIds withTmdb(Integer tmdb) {
		this.tmdb = tmdb;
		return this;
	}

	@Override
	public boolean hasAnyId() {
		return trakt > 0 || (tvdb != null ? tvdb.compareTo(0) : 0) > 0 || (tmdb != null ? tmdb.compareTo(0)
				: 0) > 0;
	}

	@Override
	public String getBestId() {
		if (trakt > 0) return String.valueOf(trakt);

		if (tvdb != null && tvdb.compareTo(0) > 0) return tvdb.toString();

		if (tmdb != null && tmdb.compareTo(0) > 0) return tmdb.toString();

		return "";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSeasonIdsImpl that = (TraktSeasonIdsImpl) o;

		return trakt == that.trakt && (tvdb != null ? tvdb.equals(that.tvdb) : that.tvdb == null) && (tmdb != null
				? tmdb.equals(that.tmdb) : that.tmdb == null);
	}

	@Override
	public int hashCode() {
		int result = trakt;
		result = 31 * result + (tvdb != null ? tvdb.hashCode() : 0);
		result = 31 * result + (tmdb != null ? tmdb.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSeasonIds{" + "trakt=" + trakt + ", tvdb=" + tvdb + ", tmdb=" + tmdb + '}';
	}
}
