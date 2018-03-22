package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.TraktUserShowsStatistics;

public class TraktUserShowsStatisticsImpl
		implements media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.TraktUserShowsStatistics {
	private Integer watched;
	private Integer collected;
	private Integer ratings;
	private Integer comments;

	@Override
	public Integer getWatched() {
		return watched;
	}

	@Override
	public void setWatched(Integer watched) {
		this.watched = watched;
	}

	@Override
	public TraktUserShowsStatistics withWatched(Integer watched) {
		this.watched = watched;
		return this;
	}

	@Override
	public Integer getCollected() {
		return collected;
	}

	@Override
	public void setCollected(Integer collected) {
		this.collected = collected;
	}

	@Override
	public TraktUserShowsStatistics withCollected(Integer collected) {
		this.collected = collected;
		return this;
	}

	@Override
	public Integer getRatings() {
		return ratings;
	}

	@Override
	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

	@Override
	public TraktUserShowsStatistics withRatings(Integer ratings) {
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
	public TraktUserShowsStatistics withComments(Integer comments) {
		this.comments = comments;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserShowsStatisticsImpl that = (TraktUserShowsStatisticsImpl) o;

		if (watched != null ? !watched.equals(that.watched) : that.watched != null) return false;
		if (collected != null ? !collected.equals(that.collected) : that.collected != null) return false;
		if (ratings != null ? !ratings.equals(that.ratings) : that.ratings != null) return false;
		return comments != null ? comments.equals(that.comments) : that.comments == null;
	}

	@Override
	public int hashCode() {
		int result = watched != null ? watched.hashCode() : 0;
		result = 31 * result + (collected != null ? collected.hashCode() : 0);
		result = 31 * result + (ratings != null ? ratings.hashCode() : 0);
		result = 31 * result + (comments != null ? comments.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserShowsStatistics{" + "watched=" + watched + ", collected=" + collected + ", ratings=" + ratings + ", comments=" + comments + '}';
	}
}
