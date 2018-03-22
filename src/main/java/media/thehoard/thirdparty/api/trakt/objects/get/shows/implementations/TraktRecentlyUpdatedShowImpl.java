package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktRecentlyUpdatedShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;

import java.util.Date;

public class TraktRecentlyUpdatedShowImpl implements TraktRecentlyUpdatedShow {
	@SerializedName("updated_at")
	private Date updatedAt;
	private TraktShowImpl show;

	@Override
	public Date getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public TraktRecentlyUpdatedShow withUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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
	public TraktRecentlyUpdatedShow withShow(TraktShowImpl show) {
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
	public TraktRecentlyUpdatedShowImpl withTitle(String title) {
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
	public TraktRecentlyUpdatedShowImpl withYear(Integer year) {
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
	public TraktRecentlyUpdatedShowImpl withIds(TraktShowIdsImpl ids) {
		if (show != null)
			show.setIds(ids);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktRecentlyUpdatedShowImpl that = (TraktRecentlyUpdatedShowImpl) o;

		return (updatedAt != null ? updatedAt.equals(that.updatedAt) : that.updatedAt == null) && (show != null ? show
				.equals(that.show) : that.show == null);
	}

	@Override
	public int hashCode() {
		int result = updatedAt != null ? updatedAt.hashCode() : 0;
		result = 31 * result + (show != null ? show.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktRecentlyUpdatedShow{" + "updatedAt=" + updatedAt + ", show=" + show + '}';
	}
}
