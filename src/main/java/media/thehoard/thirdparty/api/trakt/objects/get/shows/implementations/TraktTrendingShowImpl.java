package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktTrendingShow;

public class TraktTrendingShowImpl implements TraktTrendingShow {
	private Integer watchers;
	private TraktShowImpl show;

	@Override
	public Integer getWatchers() {
		return watchers;
	}

	@Override
	public void setWatchers(Integer watchers) {
		this.watchers = watchers;
	}

	@Override
	public TraktTrendingShow withWatchers(Integer watchers) {
		this.watchers = watchers;
		return this;
	}

	@Override
	public TraktShow getShow() {
		return show;
	}

	@Override
	public void setShow(TraktShowImpl show) {
		this.show = show;
	}

	@Override
	public TraktTrendingShow withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public String getTitle() {
		return show != null ? show.getTitle() : null;
	}

	@Override
	public void setTitle(String title) {
		if (show != null)
			show.setTitle(title);
	}

	@Override
	public TraktTrendingShowImpl withTitle(String title) {
		if (show != null)
			show.setTitle(title);
		return this;
	}

	@Override
	public Integer getYear() {
		return show != null ? show.getYear() : null;
	}

	@Override
	public void setYear(Integer year) {
		if (show != null)
			show.setYear(year);
	}

	@Override
	public TraktTrendingShowImpl withYear(Integer year) {
		if (show != null)
			show.setYear(year);
		return this;
	}

	@Override
	public TraktShowIdsImpl getIds() {
		return show != null ? show.getIds() : null;
	}

	@Override
	public void setIds(TraktShowIdsImpl ids) {
		if (show != null)
			show.setIds(ids);
	}

	@Override
	public TraktTrendingShowImpl withIds(TraktShowIdsImpl ids) {
		if (show != null)
			show.setIds(ids);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktTrendingShowImpl that = (TraktTrendingShowImpl) o;

		return (watchers != null ? watchers.equals(that.watchers) : that.watchers == null) && (show != null ? show
				.equals(that.show) : that.show == null);
	}

	@Override
	public int hashCode() {
		int result = watchers != null ? watchers.hashCode() : 0;
		result = 31 * result + (show != null ? show.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktTrendingShow{" + "watchers=" + watchers + ", show=" + show + '}';
	}
}
