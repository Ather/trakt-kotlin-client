package media.thehoard.thirdparty.api.trakt.objects.basic;

import java.util.Map;

public interface TraktRating {
	Float getRating();

	void setRating(Float rating);

	Integer getVotes();

	void setVotes(Integer votes);

	Map<String, Integer> getDistribution();

	void setDistribution(Map<String, Integer> distribution);
}
