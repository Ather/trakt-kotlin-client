package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.TraktUserRatingsStatistics;

import java.util.Map;

public class TraktUserRatingsStatisticsImpl implements TraktUserRatingsStatistics {
	private Integer total;
	private Map<String, Integer> distribution;

	@Override
	public Integer getTotal() {
		return total;
	}

	@Override
	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public TraktUserRatingsStatistics withTotal(Integer total) {
		this.total = total;
		return this;
	}

	@Override
	public Map<String, Integer> getDistribution() {
		return distribution;
	}

	@Override
	public void setDistribution(Map<String, Integer> distribution) {
		this.distribution = distribution;
	}

	@Override
	public TraktUserRatingsStatistics withDistribution(Map<String, Integer> distribution) {
		this.distribution = distribution;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserRatingsStatisticsImpl that = (TraktUserRatingsStatisticsImpl) o;

		if (total != null ? !total.equals(that.total) : that.total != null) return false;
		return distribution != null ? distribution.equals(that.distribution) : that.distribution == null;
	}

	@Override
	public int hashCode() {
		int result = total != null ? total.hashCode() : 0;
		result = 31 * result + (distribution != null ? distribution.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserRatingsStatistics{" + "total=" + total + ", distribution=" + distribution + '}';
	}
}
