package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics;

import java.util.Map;

public interface TraktUserRatingsStatistics {
	Integer getTotal();

	void setTotal(Integer total);

	TraktUserRatingsStatistics withTotal(Integer total);

	Map<String, Integer> getDistribution();

	void setDistribution(Map<String, Integer> distribution);

	TraktUserRatingsStatistics withDistribution(Map<String, Integer> distribution);
}
