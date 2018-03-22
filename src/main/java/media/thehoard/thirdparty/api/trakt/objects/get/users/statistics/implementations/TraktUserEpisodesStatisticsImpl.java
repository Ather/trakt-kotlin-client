package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.TraktUserEpisodesStatistics;

public class TraktUserEpisodesStatisticsImpl implements TraktUserEpisodesStatistics {
	private Integer plays;
	private Integer watched;
	private Integer minutes;
	private Integer collected;
	private Integer ratings;
	private Integer comments;

	@Override
	public Integer getPlays() {
		return plays;
	}

	@Override
	public void setPlays(Integer plays) {
		this.plays = plays;
	}

	@Override
	public TraktUserEpisodesStatistics withPlays(Integer plays) {
		this.plays = plays;
		return this;
	}

	@Override
	public Integer getWatched() {
		return watched;
	}

	@Override
	public void setWatched(Integer watched) {
		this.watched = watched;
	}

	@Override
	public TraktUserEpisodesStatistics withWatched(Integer watched) {
		this.watched = watched;
		return this;
	}

	@Override
	public Integer getMinutes() {
		return minutes;
	}

	@Override
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	@Override
	public TraktUserEpisodesStatistics withMinutes(Integer minutes) {
		this.minutes = minutes;
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
	public TraktUserEpisodesStatistics withCollected(Integer collected) {
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
	public TraktUserEpisodesStatistics withRatings(Integer ratings) {
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
	public TraktUserEpisodesStatistics withComments(Integer comments) {
		this.comments = comments;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserEpisodesStatisticsImpl that = (TraktUserEpisodesStatisticsImpl) o;

		if (plays != null ? !plays.equals(that.plays) : that.plays != null) return false;
		if (watched != null ? !watched.equals(that.watched) : that.watched != null) return false;
		if (minutes != null ? !minutes.equals(that.minutes) : that.minutes != null) return false;
		if (collected != null ? !collected.equals(that.collected) : that.collected != null) return false;
		if (ratings != null ? !ratings.equals(that.ratings) : that.ratings != null) return false;
		return comments != null ? comments.equals(that.comments) : that.comments == null;
	}

	@Override
	public int hashCode() {
		int result = plays != null ? plays.hashCode() : 0;
		result = 31 * result + (watched != null ? watched.hashCode() : 0);
		result = 31 * result + (minutes != null ? minutes.hashCode() : 0);
		result = 31 * result + (collected != null ? collected.hashCode() : 0);
		result = 31 * result + (ratings != null ? ratings.hashCode() : 0);
		result = 31 * result + (comments != null ? comments.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserEpisodesStatistics{" + "plays=" + plays + ", watched=" + watched + ", minutes=" + minutes + ", collected=" + collected + ", ratings=" + ratings + ", comments=" + comments + '}';
	}
}
