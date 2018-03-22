package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktRating;

import java.util.Map;

public class TraktRatingImpl implements TraktRating<TraktRatingImpl> {
	private Float rating;
	private Integer votes;
	private Map<String, Integer> distribution;

	@Override
	public Float getRating() {
		return rating;
	}

	@Override
	public void setRating(Float rating) {
		this.rating = rating;
	}

	@Override
	public TraktRatingImpl withRating(Float rating) {
		this.rating = rating;
		return this;
	}

	@Override
	public Integer getVotes() {
		return votes;
	}

	@Override
	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	@Override
	public TraktRatingImpl withVotes(Integer votes) {
		this.votes = votes;
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
	public TraktRatingImpl withDistribution(Map<String, Integer> distribution) {
		this.distribution = distribution;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktRatingImpl that = (TraktRatingImpl) o;

		return (rating != null ? rating.equals(that.rating) : that.rating == null) && (votes != null ? votes
				.equals(that.votes) : that.votes == null) && (distribution != null ? distribution
				.equals(that.distribution) : that.distribution == null);
	}

	@Override
	public int hashCode() {
		int result = rating != null ? rating.hashCode() : 0;
		result = 31 * result + (votes != null ? votes.hashCode() : 0);
		result = 31 * result + (distribution != null ? distribution.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktRating{" + "rating=" + rating + ", votes=" + votes + ", distribution=" + distribution + '}';
	}
}
