package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeExtendedFull;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds;

import java.time.Instant;
import java.util.List;

public class TraktEpisodeExtendedFullImpl implements TraktEpisodeExtendedFull {
	private Integer season;
	private Integer number;
	private String title;
	private TraktEpisodeIdsImpl ids;

	@SerializedName("number_abs")
	private Integer numberAbsolute;
	private String overview;
	@SerializedName("first_aired")
	private Instant firstAired;
	@SerializedName("updated_at")
	private Instant updatedAt;
	private Float rating;
	private Integer votes;
	@SerializedName("comment_count")
	private Integer commentCount;
	@SerializedName("available_translations")
	private List<String> availableTranslations;
	private Integer runtime;

	@Override
	public Integer getSeason() {
		return season;
	}

	@Override
	public void setSeason(Integer season) {
		this.season = season;
	}

	@Override
	public TraktEpisodeExtendedFullImpl withSeason(Integer season) {
		this.season = season;
		return this;
	}

	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public TraktEpisodeExtendedFullImpl withNumber(Integer number) {
		this.number = number;
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
	public TraktEpisodeExtendedFullImpl withTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public TraktEpisodeIds getIds() {
		return ids;
	}

	@Override
	public void setIds(TraktEpisodeIdsImpl ids) {
		this.ids = ids;
	}

	@Override
	public TraktEpisodeExtendedFullImpl withIds(TraktEpisodeIdsImpl ids) {
		this.ids = ids;
		return this;
	}

	@Override
	public Integer getNumberAbsolute() {
		return numberAbsolute;
	}

	@Override
	public void setNumberAbsolute(Integer numberAbsolute) {
		this.numberAbsolute = numberAbsolute;
	}

	@Override
	public TraktEpisodeExtendedFull withNumberAbsolute(Integer numberAbsolute) {
		this.numberAbsolute = numberAbsolute;
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
	public TraktEpisodeExtendedFull withOverview(String overview) {
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
	public TraktEpisodeExtendedFull withFirstAired(Instant firstAired) {
		this.firstAired = firstAired;
		return this;
	}

	@Override
	public Instant getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public TraktEpisodeExtendedFull withUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
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
	public TraktEpisodeExtendedFull withRating(Float rating) {
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
	public TraktEpisodeExtendedFull withVotes(Integer votes) {
		this.votes = votes;
		return this;
	}

	@Override
	public Integer getCommentCount() {
		return commentCount;
	}

	@Override
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public TraktEpisodeExtendedFull withCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
		return this;
	}

	@Override
	public List<String> getAvailableTranslations() {
		return availableTranslations;
	}

	@Override
	public void setAvailableTranslations(List<String> availableTranslations) {
		this.availableTranslations = availableTranslations;
	}

	@Override
	public TraktEpisodeExtendedFull withAvailableTranslations(List<String> availableTranslations) {
		this.availableTranslations = availableTranslations;
		return this;
	}

	@Override
	public Integer getRuntime() {
		return runtime;
	}

	@Override
	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	@Override
	public TraktEpisodeExtendedFull withRuntime(Integer runtime) {
		this.runtime = runtime;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktEpisodeExtendedFullImpl that = (TraktEpisodeExtendedFullImpl) o;

		return (season != null ? season.equals(that.season) : that.season == null) && (number != null ? number
				.equals(that.number) : that.number == null) && (title != null ? title.equals(that.title)
				: that.title == null) && (ids != null ? ids.equals(that.ids) : that.ids == null) && (
				numberAbsolute != null ? numberAbsolute.equals(that.numberAbsolute) : that.numberAbsolute == null) && (
				overview != null ? overview.equals(that.overview) : that.overview == null) && (firstAired != null
				? firstAired.equals(that.firstAired) : that.firstAired == null) && (updatedAt != null ? updatedAt
				.equals(that.updatedAt) : that.updatedAt == null) && (rating != null ? rating.equals(that.rating)
				: that.rating == null) && (votes != null ? votes.equals(that.votes) : that.votes == null) && (
				commentCount != null ? commentCount.equals(that.commentCount) : that.commentCount == null) && (
				availableTranslations != null ? availableTranslations.equals(that.availableTranslations)
						: that.availableTranslations == null) && (runtime != null ? runtime.equals(that.runtime)
				: that.runtime == null);
	}

	@Override
	public int hashCode() {
		int result = season != null ? season.hashCode() : 0;
		result = 31 * result + (number != null ? number.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (ids != null ? ids.hashCode() : 0);
		result = 31 * result + (numberAbsolute != null ? numberAbsolute.hashCode() : 0);
		result = 31 * result + (overview != null ? overview.hashCode() : 0);
		result = 31 * result + (firstAired != null ? firstAired.hashCode() : 0);
		result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
		result = 31 * result + (rating != null ? rating.hashCode() : 0);
		result = 31 * result + (votes != null ? votes.hashCode() : 0);
		result = 31 * result + (commentCount != null ? commentCount.hashCode() : 0);
		result = 31 * result + (availableTranslations != null ? availableTranslations.hashCode() : 0);
		result = 31 * result + (runtime != null ? runtime.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktEpisodeExtended{" + "season=" + season + ", number=" + number + ", title='" + title + '\'' + ", ids=" + ids + ", numberAbsolute=" + numberAbsolute + ", overview='" + overview + '\'' + ", firstAired=" + firstAired + ", updatedAt=" + updatedAt + ", rating=" + rating + ", votes=" + votes + ", commentCount=" + commentCount + ", availableTranslations=" + availableTranslations + ", runtime=" + runtime + '}';
	}
}
