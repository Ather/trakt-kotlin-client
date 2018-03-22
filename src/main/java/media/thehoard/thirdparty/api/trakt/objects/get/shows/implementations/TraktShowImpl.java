package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;

public class TraktShowImpl implements TraktShow {
	private String title;
	private Integer year;
	private TraktShowIdsImpl ids;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public TraktShow withTitle(String title) {
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
	public TraktShow withYear(Integer year) {
		this.year = year;
		return this;
	}

	@Override
	public TraktShowIdsImpl getIds() {
		return ids;
	}

	@Override
	public void setIds(TraktShowIdsImpl ids) {
		this.ids = ids;
	}

	@Override
	public TraktShow withIds(TraktShowIdsImpl ids) {
		this.ids = ids;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktShowImpl traktShow = (TraktShowImpl) o;

		return (title != null ? title.equals(traktShow.title) : traktShow.title == null) && (year != null ? year
				.equals(traktShow.year) : traktShow.year == null) && (ids != null ? ids.equals(traktShow.ids)
				: traktShow.ids == null);
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
		return "TraktShow{" + "title='" + title + '\'' + ", year=" + year + ", ids=" + ids + '}';
	}
}
