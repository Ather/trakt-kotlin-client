package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;

public class TraktMovieImpl implements TraktMovie {
	private String title;
	private Integer year;
	private TraktMovieIds ids;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public TraktMovieImpl withTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public Integer getYear() {
		return year;
	}

	@Override
	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public TraktMovieImpl withYear(Integer year) {
		this.year = year;
		return this;
	}

	@Override
	public TraktMovieIds getIds() {
		return ids;
	}

	@Override
	public void setIds(TraktMovieIds ids) {
		this.ids = ids;
	}

	@Override
	public TraktMovieImpl withIds(TraktMovieIds ids) {
		this.ids = ids;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktMovieImpl that = (TraktMovieImpl) o;

		return (title != null ? title.equals(that.title) : that.title == null) && (year != null ? year.equals(that.year)
				: that.year == null) && (ids != null ? ids.equals(that.ids) : that.ids == null);
	}

	@Override
	public int hashCode() {
		int result = title != null ? title.hashCode() : 0;
		result = 31 * result + (year != null ? year.hashCode() : 0);
		result = 31 * result + (ids != null ? ids.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktMovie{" + "title='" + title + '\'' + ", year=" + year + ", ids=" + ids + '}';
	}
}
