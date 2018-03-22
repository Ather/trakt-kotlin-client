package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktMostAnticipiatedShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;

public class TraktMostAnticipatedShowImpl implements TraktMostAnticipiatedShow {
	@SerializedName("list_count")
	private Integer listCount;
	private TraktShowImpl show;

	@Override
	public Integer getListCount() {
		return listCount;
	}

	@Override
	public void setListCount(Integer listCount) {
		this.listCount = listCount;
	}

	@Override
	public TraktMostAnticipiatedShow withListCount(Integer listCount) {
		this.listCount = listCount;
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
	public TraktMostAnticipiatedShow withShow(TraktShowImpl show) {
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
	public TraktMostAnticipatedShowImpl withTitle(String title) {
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
	public TraktMostAnticipatedShowImpl withYear(Integer year) {
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
	public TraktMostAnticipatedShowImpl withIds(TraktShowIdsImpl ids) {
		if (show != null)
			show.setIds(ids);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktMostAnticipatedShowImpl that = (TraktMostAnticipatedShowImpl) o;

		return (listCount != null ? listCount.equals(that.listCount) : that.listCount == null) && (show != null ? show
				.equals(that.show) : that.show == null);
	}

	@Override
	public int hashCode() {
		int result = listCount != null ? listCount.hashCode() : 0;
		result = 31 * result + (show != null ? show.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktMostAnticipiatedShowImpl{" + "listCount=" + listCount + ", show=" + show + '}';
	}
}
