package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.TraktUserSeasonsStatistics;

public class TraktUserSeasonsStatisticsImpl implements TraktUserSeasonsStatistics {
	private Integer ratings;
	private Integer comments;

	@Override
	public Integer getRatings() {
		return ratings;
	}

	@Override
	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

	@Override
	public TraktUserSeasonsStatistics withRatings(Integer ratings) {
		this.ratings = ratings;
		return this;
	}

	@Override
	public Integer getComments() {
		return comments;
	}

	@Override
	public void setComments(Integer comments) {
		this.comments = comments;
	}

	@Override
	public TraktUserSeasonsStatistics withComments(Integer comments) {
		this.comments = comments;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserSeasonsStatisticsImpl that = (TraktUserSeasonsStatisticsImpl) o;

		if (ratings != null ? !ratings.equals(that.ratings) : that.ratings != null) return false;
		return comments != null ? comments.equals(that.comments) : that.comments == null;
	}

	@Override
	public int hashCode() {
		int result = ratings != null ? ratings.hashCode() : 0;
		result = 31 * result + (comments != null ? comments.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserSeasonsStatistics{" + "ratings=" + ratings + ", comments=" + comments + '}';
	}
}
