package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktShowStatus;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowAirs;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowExtended;

import java.time.Instant;
import java.util.List;

public class TraktShowExtendedImpl implements TraktShowExtended {
	private String title;
	private Integer year;
	private TraktShowIdsImpl ids;

	private String overview;
	@SerializedName("first_aired")
	private Instant firstAired;
	private TraktShowAirsImpl airs;
	private Integer runtime;
	//TODO Look into Enum here
	private String certification;
	private String network;
	private String country;
	@SerializedName("updated_at")
	private Instant updatedAt;
	private String trailer;
	private String homepage;
	private TraktShowStatus status;
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
	@SerializedName("aired_episodes")
	private Integer airedEpisodes;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public TraktShowExtended withTitle(String title) {
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
	public TraktShowExtended withYear(Integer year) {
		this.year = year;
		return this;
	}

	@Override
	public TraktShowIdsImpl getIds() {
		return ids;
	}

	@Override
	public void setIds(TraktShowIdsImpl ids) {
		this.ids = ids;
	}

	@Override
	public TraktShowExtended withIds(TraktShowIdsImpl ids) {
		this.ids = ids;
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
	public TraktShowExtended withOverview(String overview) {
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
	public TraktShowExtended withFirstAired(Instant firstAired) {
		this.firstAired = firstAired;
		return this;
	}

	@Override
	public TraktShowAirs getAirs() {
		return airs;
	}

	@Override
	public void setAirs(TraktShowAirsImpl airs) {
		this.airs = airs;
	}

	@Override
	public TraktShowExtended withAirs(TraktShowAirsImpl airs) {
		this.airs = airs;
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
	public TraktShowExtended withRuntime(Integer runtime) {
		this.runtime = runtime;
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
	public TraktShowExtended withCertification(String certification) {
		this.certification = certification;
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
	public TraktShowExtended withNetwork(String network) {
		this.network = network;
		return this;
	}

	@Override
	public String getCountry() {
		return country;
	}

	@Override
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public TraktShowExtended withCountry(String country) {
		this.country = country;
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
	public TraktShowExtended withUpdatedAt(Instant updatedAt) {
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
	public TraktShowExtended withTrailer(String trailer) {
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
	public TraktShowExtended withHomepage(String homepage) {
		this.homepage = homepage;
		return this;
	}

	@Override
	public TraktShowStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(TraktShowStatus status) {
		this.status = status;
	}

	@Override
	public TraktShowExtended withStatus(TraktShowStatus status) {
		this.status = status;
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
	public TraktShowExtended withRating(Float rating) {
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
	public TraktShowExtended withVotes(Integer votes) {
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
	public TraktShowExtended withCommentCount(Integer commentCount) {
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
	public TraktShowExtended withLanguage(String language) {
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
	public TraktShowExtended withAvailableTranslations(List<String> availableTranslations) {
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
	public TraktShowExtended withGenres(List<String> genres) {
		this.genres = genres;
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
	public TraktShowExtended withAiredEpisodes(Integer airedEpisodes) {
		this.airedEpisodes = airedEpisodes;
		return this;
	}
}
