package media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonExtended;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeasonIds;

import java.time.Instant;

public class TraktSeasonExtendedImpl implements TraktSeasonExtended {
	private Integer number;
	private TraktSeasonIdsImpl ids;

	private Float rating;
	private Integer votes;
	@SerializedName("episode_count")
	private Integer episodeCount;
	@SerializedName("aired_episodes")
	private Integer airedEpisodes;
	private String title;
	private String overview;
	@SerializedName("first_aired")
	private Instant firstAired;
	private String network;

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktSeasonExtended withNumber(Integer number) {
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
	public TraktSeasonExtended withIds(TraktSeasonIdsImpl ids) {
		this.ids = ids;
		return this;
	}

	@Override
	public Float getRating() {
		return rating;
	}

	@Override
	public void setRating(Float rating) {
		this.rating = rating;
	}

	@Override
	public TraktSeasonExtended withRating(Float rating) {
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
	public TraktSeasonExtended withVotes(Integer votes) {
		this.votes = votes;
		return this;
	}

	@Override
	public Integer getEpisodeCount() {
		return episodeCount;
	}

	@Override
	public void setEpisodeCount(Integer episodeCount) {
		this.episodeCount = episodeCount;
	}

	@Override
	public TraktSeasonExtended withEpisodeCount(Integer episodeCount) {
		this.episodeCount = episodeCount;
		return this;
	}

	@Override
	public Integer getAiredEpisodes() {
		return airedEpisodes;
	}

	@Override
	public void setAiredEpisodes(Integer airedEpisodes) {
		this.airedEpisodes = airedEpisodes;
	}

	@Override
	public TraktSeasonExtended withAiredEpisodes(Integer airedEpisodes) {
		this.airedEpisodes = airedEpisodes;
		return this;
	}

	@Override
	public String getTitle() {
		return title;

	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public TraktSeasonExtended withTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public String getOverview() {
		return overview;
	}

	@Override
	public void setOverview(String overview) {
		this.overview = overview;
	}

	@Override
	public TraktSeasonExtended withOverview(String overview) {
		this.overview = overview;
		return this;
	}

	@Override
	public Instant getFirstAired() {
		return firstAired;
	}

	@Override
	public void setFirstAired(Instant firstAired) {
		this.firstAired = firstAired;
	}

	@Override
	public TraktSeasonExtended withFirstAired(Instant firstAired) {
		this.firstAired = firstAired;
		return this;
	}

	@Override
	public String getNetwork() {
		return network;
	}

	@Override
	public void setNetwork(String network) {
		this.network = network;
	}

	@Override
	public TraktSeasonExtended withNetwork(String network) {
		this.network = network;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSeasonExtendedImpl that = (TraktSeasonExtendedImpl) o;

		return (number != null ? number.equals(that.number) : that.number == null) && (ids != null ? ids
				.equals(that.ids) : that.ids == null) && (rating != null ? rating.equals(that.rating)
				: that.rating == null) && (votes != null ? votes.equals(that.votes) : that.votes == null) && (
				episodeCount != null ? episodeCount.equals(that.episodeCount) : that.episodeCount == null) && (
				airedEpisodes != null ? airedEpisodes.equals(that.airedEpisodes) : that.airedEpisodes == null) && (
				title != null ? title.equals(that.title) : that.title == null) && (overview != null ? overview
				.equals(that.overview) : that.overview == null) && (firstAired != null ? firstAired
				.equals(that.firstAired) : that.firstAired == null) && (network != null ? network.equals(that.network)
				: that.network == null);
	}

	@Override
	public int hashCode() {
		int result = number != null ? number.hashCode() : 0;
		result = 31 * result + (ids != null ? ids.hashCode() : 0);
		result = 31 * result + (rating != null ? rating.hashCode() : 0);
		result = 31 * result + (votes != null ? votes.hashCode() : 0);
		result = 31 * result + (episodeCount != null ? episodeCount.hashCode() : 0);
		result = 31 * result + (airedEpisodes != null ? airedEpisodes.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (overview != null ? overview.hashCode() : 0);
		result = 31 * result + (firstAired != null ? firstAired.hashCode() : 0);
		result = 31 * result + (network != null ? network.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSeasonExtended{" + "number=" + number + ", ids=" + ids + ", rating=" + rating + ", votes=" + votes + ", episodeCount=" + episodeCount + ", airedEpisodes=" + airedEpisodes + ", title='" + title + '\'' + ", overview='" + overview + '\'' + ", firstAired=" + firstAired + ", network='" + network + '\'' + '}';
	}
}
