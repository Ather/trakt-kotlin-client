package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktStatistics;

public class TraktStatisticsImpl implements TraktStatistics {
	private Integer watchers;
	private Integer plays;
	private Integer collectors;
	@SerializedName("collected_episodes")
	private Integer collectedEpisodes;
	private Integer comments;
	private Integer lists;
	private Integer votes;

	@Override
	public Integer getWatchers() {
		return watchers;
	}

	@Override
	public void setWatchers(Integer watchers) {
		this.watchers = watchers;
	}

	@Override
	public TraktStatistics withWatchers(Integer watchers) {
		this.watchers = watchers;
		return this;
	}

	@Override
	public Integer getPlays() {
		return plays;
	}

	@Override
	public void setPlays(Integer plays) {
		this.plays = plays;
	}

	@Override
	public TraktStatistics withPlays(Integer plays) {
		this.plays = plays;
		return this;
	}

	@Override
	public Integer getCollectors() {
		return collectors;
	}

	@Override
	public void setCollectors(Integer collectors) {
		this.collectors = collectors;
	}

	@Override
	public TraktStatistics withCollectors(Integer collectors) {
		this.collectors = collectors;
		return this;
	}

	@Override
	public Integer getCollectedEpisodes() {
		return collectedEpisodes;
	}

	@Override
	public void setCollectedEpisodes(Integer collectedEpisodes) {
		this.collectedEpisodes = collectedEpisodes;
	}

	@Override
	public TraktStatistics withCollectedEpisodes(Integer collectedEpisodes) {
		this.collectedEpisodes = collectedEpisodes;
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
	public TraktStatistics withComments(Integer comments) {
		this.comments = comments;
		return this;
	}

	@Override
	public Integer getLists() {
		return lists;
	}

	@Override
	public void setLists(Integer lists) {
		this.lists = lists;
	}

	@Override
	public TraktStatistics withLists(Integer lists) {
		this.lists = lists;
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
	public TraktStatistics withVotes(Integer votes) {
		this.votes = votes;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktStatisticsImpl that = (TraktStatisticsImpl) o;

		return (watchers != null ? watchers.equals(that.watchers) : that.watchers == null) && (plays != null ? plays
				.equals(that.plays) : that.plays == null) && (collectors != null ? collectors.equals(that.collectors)
				: that.collectors == null) && (collectedEpisodes != null ? collectedEpisodes
				.equals(that.collectedEpisodes) : that.collectedEpisodes == null) && (comments != null ? comments
				.equals(that.comments) : that.comments == null) && (lists != null ? lists.equals(that.lists)
				: that.lists == null) && (votes != null ? votes.equals(that.votes) : that.votes == null);
	}

	@Override
	public int hashCode() {
		int result = watchers != null ? watchers.hashCode() : 0;
		result = 31 * result + (plays != null ? plays.hashCode() : 0);
		result = 31 * result + (collectors != null ? collectors.hashCode() : 0);
		result = 31 * result + (collectedEpisodes != null ? collectedEpisodes.hashCode() : 0);
		result = 31 * result + (comments != null ? comments.hashCode() : 0);
		result = 31 * result + (lists != null ? lists.hashCode() : 0);
		result = 31 * result + (votes != null ? votes.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktStatistics{" + "watchers=" + watchers + ", plays=" + plays + ", collectors=" + collectors + ", collectedEpisodes=" + collectedEpisodes + ", comments=" + comments + ", lists=" + lists + ", votes=" + votes + '}';
	}
}
