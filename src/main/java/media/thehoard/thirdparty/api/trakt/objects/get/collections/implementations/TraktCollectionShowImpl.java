package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShow;
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowSeason;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.time.Instant;
import java.util.List;

public class TraktCollectionShowImpl implements TraktCollectionShow {
	@SerializedName("last_collected_at")
	private Instant lastCollectedAt;
	private TraktShowImpl show;
	private List<TraktCollectionShowSeason> seasons;

	@Override
	public Instant getLastCollectedAt() {
		return lastCollectedAt;
	}

	@Override
	public void setLastCollectedAt(Instant lastCollectedAt) {
		this.lastCollectedAt = lastCollectedAt;
	}

	@Override
	public TraktCollectionShow withLastCollectedAt(Instant lastCollectedAt) {
		this.lastCollectedAt = lastCollectedAt;
		return this;
	}

	@Override
	public TraktShowImpl getShow() {
		return show;
	}

	@Override
	public void setShow(TraktShowImpl show) {
		this.show = show;
	}

	@Override
	public TraktCollectionShow withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public List<TraktCollectionShowSeason> getSeasons() {
		return seasons;
	}

	@Override
	public void setSeasons(List<TraktCollectionShowSeason> seasons) {
		this.seasons = seasons;
	}

	@Override
	public TraktCollectionShow withSeasons(List<TraktCollectionShowSeason> seasons) {
		this.seasons = seasons;
		return this;
	}

	@Override
	public String getTitle() {return show != null ? show.getTitle() : null;}

	@Override
	public void setTitle(String title) {if (show != null) show.setTitle(title);}

	@Override
	public TraktCollectionShow withTitle(String title) {
		if (show != null) show.setTitle(title);
		return this;
	}

	@Override
	public Integer getYear() {return show != null ? show.getYear() : null;}

	@Override
	public void setYear(Integer year) {if (show != null) show.setYear(year);}

	@Override
	public TraktCollectionShow withYear(Integer year) {
		if (show != null) show.setYear(year);
		return this;
	}

	@Override
	public TraktShowIdsImpl getIds() {return show != null ? show.getIds() : null;}

	@Override
	public void setIds(TraktShowIdsImpl ids) {if (show != null) show.setIds(ids);}

	@Override
	public TraktCollectionShow withIds(TraktShowIdsImpl ids) {
		if (show != null) show.withIds(ids);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktCollectionShowImpl that = (TraktCollectionShowImpl) o;

		if (lastCollectedAt != null ? !lastCollectedAt.equals(that.lastCollectedAt) : that.lastCollectedAt != null)
			return false;
		if (show != null ? !show.equals(that.show) : that.show != null) return false;
		return seasons != null ? seasons.equals(that.seasons) : that.seasons == null;
	}

	@Override
	public int hashCode() {
		int result = lastCollectedAt != null ? lastCollectedAt.hashCode() : 0;
		result = 31 * result + (show != null ? show.hashCode() : 0);
		result = 31 * result + (seasons != null ? seasons.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktCollectionShow{" + "lastCollectedAt=" + lastCollectedAt + ", show=" + show + ", seasons=" + seasons + '}';
	}
}
