package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieExtended;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;

import java.util.Date;
import java.util.List;

public class TraktMovieExtendedImpl implements TraktMovieExtended {
	private String title;
	private Integer year;
	private TraktMovieIds ids;

	private String tagline;
	private String overview;
	private Date released;
	private Integer runtime;
	@SerializedName("updated_at")
	private Date updatedAt;
	private String trailer;
	private String homepage;
	private Float rating;
	private Integer votes;
	@SerializedName("comment_count")
	private Integer commentCount;
	//TODO Switch to language Enum
	private String language;
	//TODO Enum
	@SerializedName("available_translations")
	private List<String> availableTranslations;
	private List<String> genres;
	//TODO Look into Enum here
	private String certification;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public TraktMovieExtended withTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public Integer getYear() {
		return year;
	}

	@Override
	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public TraktMovieExtended withYear(Integer year) {
		this.year = year;
		return this;
	}

	@Override
	public TraktMovieIds getIds() {
		return ids;
	}

	@Override
	public void setIds(TraktMovieIds ids) {
		this.ids = ids;
	}

	@Override
	public TraktMovieExtended withIds(TraktMovieIds ids) {
		this.ids = ids;
		return this;
	}

	@Override
	public String getTagline() {
		return tagline;
	}

	@Override
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	@Override
	public TraktMovieExtended withTagline(String tagline) {
		this.tagline = tagline;
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
	public TraktMovieExtended withOverview(String overview) {
		this.overview = overview;
		return this;
	}

	@Override
	public Date getReleased() {
		return released;
	}

	@Override
	public void setReleased(Date released) {
		this.released = released;
	}

	@Override
	public TraktMovieExtended withReleased(Date released) {
		this.released = released;
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
	public TraktMovieExtended withRuntime(Integer runtime) {
		this.runtime = runtime;
		return this;
	}

	@Override
	public Date getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public TraktMovieExtended withUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

	@Override
	public String getTrailer() {
		return trailer;
	}

	@Override
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	@Override
	public TraktMovieExtended withTrailer(String trailer) {
		this.trailer = trailer;
		return this;
	}

	@Override
	public String getHomepage() {
		return homepage;
	}

	@Override
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	@Override
	public TraktMovieExtended withHomepage(String homepage) {
		this.homepage = homepage;
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
	public TraktMovieExtended withRating(Float rating) {
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
	public TraktMovieExtended withVotes(Integer votes) {
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
	public TraktMovieExtended withCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
		return this;
	}

	@Override
	public String getLanguage() {
		return language;
	}

	@Override
	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public TraktMovieExtended withLanguage(String language) {
		this.language = language;
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
	public TraktMovieExtended withAvailableTranslations(List<String> availableTranslations) {
		this.availableTranslations = availableTranslations;
		return this;
	}

	@Override
	public List<String> getGenres() {
		return genres;
	}

	@Override
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	@Override
	public TraktMovieExtended withGenres(List<String> genres) {
		this.genres = genres;
		return this;
	}

	@Override
	public String getCertification() {
		return certification;
	}

	@Override
	public void setCertification(String certification) {
		this.certification = certification;
	}

	@Override
	public TraktMovieExtended withCertification(String certification) {
		this.certification = certification;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktMovieExtendedImpl that = (TraktMovieExtendedImpl) o;

		return (title != null ? title.equals(that.title) : that.title == null) && (year != null ? year.equals(that.year)
				: that.year == null) && (ids != null ? ids.equals(that.ids) : that.ids == null) && (tagline != null
				? tagline.equals(that.tagline) : that.tagline == null) && (overview != null ? overview
				.equals(that.overview) : that.overview == null) && (released != null ? released.equals(that.released)
				: that.released == null) && (runtime != null ? runtime.equals(that.runtime) : that.runtime == null) && (
				updatedAt != null ? updatedAt.equals(that.updatedAt) : that.updatedAt == null) && (trailer != null
				? trailer.equals(that.trailer) : that.trailer == null) && (homepage != null ? homepage
				.equals(that.homepage) : that.homepage == null) && (rating != null ? rating.equals(that.rating)
				: that.rating == null) && (votes != null ? votes.equals(that.votes) : that.votes == null) && (
				commentCount != null ? commentCount.equals(that.commentCount) : that.commentCount == null) && (
				language != null ? language.equals(that.language) : that.language == null) && (
				availableTranslations != null ? availableTranslations.equals(that.availableTranslations)
						: that.availableTranslations == null) && (genres != null ? genres.equals(that.genres)
				: that.genres == null) && (certification != null ? certification.equals(that.certification)
				: that.certification == null);
	}

	@Override
	public int hashCode() {
		int result = title != null ? title.hashCode() : 0;
		result = 31 * result + (year != null ? year.hashCode() : 0);
		result = 31 * result + (ids != null ? ids.hashCode() : 0);
		result = 31 * result + (tagline != null ? tagline.hashCode() : 0);
		result = 31 * result + (overview != null ? overview.hashCode() : 0);
		result = 31 * result + (released != null ? released.hashCode() : 0);
		result = 31 * result + (runtime != null ? runtime.hashCode() : 0);
		result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
		result = 31 * result + (trailer != null ? trailer.hashCode() : 0);
		result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
		result = 31 * result + (rating != null ? rating.hashCode() : 0);
		result = 31 * result + (votes != null ? votes.hashCode() : 0);
		result = 31 * result + (commentCount != null ? commentCount.hashCode() : 0);
		result = 31 * result + (language != null ? language.hashCode() : 0);
		result = 31 * result + (availableTranslations != null ? availableTranslations.hashCode() : 0);
		result = 31 * result + (genres != null ? genres.hashCode() : 0);
		result = 31 * result + (certification != null ? certification.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktMovieExtended{" + "tagline='" + tagline + '\'' + ", overview='" + overview + '\'' + ", released=" + released + ", runtime=" + runtime + ", updatedAt=" + updatedAt + ", trailer='" + trailer + '\'' + ", homepage='" + homepage + '\'' + ", rating=" + rating + ", votes=" + votes + ", commentCount=" + commentCount + ", language='" + language + '\'' + ", availableTranslations=" + availableTranslations + ", genres=" + genres + ", certification='" + certification + '\'' + ", title='" + getTitle() + '\'' + ", year=" + getYear() + ", ids=" + getIds() + '}';
	}
}
