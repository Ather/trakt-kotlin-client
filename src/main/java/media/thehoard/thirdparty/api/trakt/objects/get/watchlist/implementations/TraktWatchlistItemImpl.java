package media.thehoard.thirdparty.api.trakt.objects.get.watchlist.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.watchlist.TraktWatchlistItem;

import java.util.Date;

public class TraktWatchlistItemImpl implements TraktWatchlistItem {
	@SerializedName("listed_at")
	private Date listedAt;
	private TraktSyncItemType type;
	private TraktMovieImpl movie;
	private TraktShowImpl show;
	private TraktSeasonImpl season;
	private TraktEpisodeImpl episode;

	@Override
	public Date getListedAt() {
		return listedAt;
	}

	@Override
	public void setListedAt(Date listedAt) {
		this.listedAt = listedAt;
	}

	@Override
	public TraktWatchlistItem withListedAt(Date listedAt) {
		this.listedAt = listedAt;
		return this;
	}

	@Override
	public TraktSyncItemType getType() {
		return type;
	}

	@Override
	public void setType(TraktSyncItemType type) {
		this.type = type;
	}

	@Override
	public TraktWatchlistItem withType(TraktSyncItemType type) {
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
	public TraktWatchlistItem withMovie(TraktMovieImpl movie) {
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
	public TraktWatchlistItem withShow(TraktShowImpl show) {
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
	public TraktWatchlistItem withSeason(TraktSeasonImpl season) {
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
	public TraktWatchlistItem withEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktWatchlistItemImpl that = (TraktWatchlistItemImpl) o;

		if (listedAt != null ? !listedAt.equals(that.listedAt) : that.listedAt != null) return false;
		if (type != that.type) return false;
		if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
		if (show != null ? !show.equals(that.show) : that.show != null) return false;
		if (season != null ? !season.equals(that.season) : that.season != null) return false;
		return episode != null ? episode.equals(that.episode) : that.episode == null;
	}

	@Override
	public int hashCode() {
		int result = listedAt != null ? listedAt.hashCode() : 0;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		result = 31 * result + (season != null ? season.hashCode() : 0);
		result = 31 * result + (episode != null ? episode.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktWatchlistItem{" + "listedAt=" + listedAt + ", type=" + type + ", movie=" + movie + ", show=" + show + ", season=" + season + ", episode=" + episode + '}';
	}
}
