package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonIds;

public class TraktSeasonImpl implements TraktSeason {
	private Integer number;
	private TraktSeasonIdsImpl ids;

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktSeason withNumber(Integer number) {
		this.number = number;
		return this;
	}

	@Override
	public TraktSeasonIds getIds() {
		return ids;
	}

	@Override
	public void setIds(TraktSeasonIdsImpl ids) {
		this.ids = ids;
	}

	@Override
	public TraktSeason withIds(TraktSeasonIdsImpl ids) {
		this.ids = ids;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSeasonImpl that = (TraktSeasonImpl) o;

		return (number != null ? number.equals(that.number) : that.number == null) && (ids != null ? ids
				.equals(that.ids) : that.ids == null);
	}

	@Override
	public int hashCode() {
		int result = number != null ? number.hashCode() : 0;
		result = 31 * result + (ids != null ? ids.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSeason{" + "number=" + number + ", ids=" + ids + '}';
	}
}
