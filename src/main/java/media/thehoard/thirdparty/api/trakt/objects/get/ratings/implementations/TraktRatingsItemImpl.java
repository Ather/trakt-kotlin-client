package media.thehoard.thirdparty.api.trakt.objects.get.ratings.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktRatingsItemType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.ratings.TraktRatingsItem;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.util.Date;

public class TraktRatingsItemImpl implements TraktRatingsItem {
	@SerializedName("rated_at")
	private Date ratedAt;
	private Integer rating;
	private TraktRatingsItemType type;
	private TraktMovieImpl movie;
	private TraktShowImpl show;
	private TraktSeasonImpl season;
	private TraktEpisodeImpl episode;

	@Override
	public Date getRatedAt() {
		return ratedAt;
	}

	@Override
	public void setRatedAt(Date ratedAt) {
		this.ratedAt = ratedAt;
	}

	@Override
	public TraktRatingsItem withRatedAt(Date ratedAt) {
		this.ratedAt = ratedAt;
		return this;
	}

	@Override
	public Integer getRating() {
		return rating;
	}

	@Override
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public TraktRatingsItem withRating(Integer rating) {
		this.rating = rating;
		return this;
	}

	@Override
	public TraktRatingsItemType getType() {
		return type;
	}

	@Override
	public void setType(TraktRatingsItemType type) {
		this.type = type;
	}

	@Override
	public TraktRatingsItem withType(TraktRatingsItemType type) {
		this.type = type;
		return this;
	}

	@Override
	public TraktMovieImpl getMovie() {
		return movie;
	}

	@Override
	public void setMovie(TraktMovieImpl movie) {
		this.movie = movie;
	}

	@Override
	public TraktRatingsItem withMovie(TraktMovieImpl movie) {
		this.movie = movie;
		return this;
	}

	@Override
	public TraktShowImpl getShow() {
		return show;
	}

	@Override
	public void setShow(TraktShowImpl show) {
		this.show = show;
	}

	@Override
	public TraktRatingsItem withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public TraktSeasonImpl getSeason() {
		return season;
	}

	@Override
	public void setSeason(TraktSeasonImpl season) {
		this.season = season;
	}

	@Override
	public TraktRatingsItem withSeason(TraktSeasonImpl season) {
		this.season = season;
		return this;
	}

	@Override
	public TraktEpisodeImpl getEpisode() {
		return episode;
	}

	@Override
	public void setEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
	}

	@Override
	public TraktRatingsItem withEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktRatingsItemImpl that = (TraktRatingsItemImpl) o;

		if (ratedAt != null ? !ratedAt.equals(that.ratedAt) : that.ratedAt != null) return false;
		if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
		if (type != that.type) return false;
		if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
		if (show != null ? !show.equals(that.show) : that.show != null) return false;
		if (season != null ? !season.equals(that.season) : that.season != null) return false;
		return episode != null ? episode.equals(that.episode) : that.episode == null;
	}

	@Override
	public int hashCode() {
		int result = ratedAt != null ? ratedAt.hashCode() : 0;
		result = 31 * result + (rating != null ? rating.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		result = 31 * result + (season != null ? season.hashCode() : 0);
		result = 31 * result + (episode != null ? episode.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktRatingsItem{" + "ratedAt=" + ratedAt + ", rating=" + rating + ", type=" + type + ", movie=" + movie + ", show=" + show + ", season=" + season + ", episode=" + episode + '}';
	}
}
