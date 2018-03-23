package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktHiddenItemType;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserHiddenItem;

import java.time.Instant;

public class TraktUserHiddenItemImpl implements TraktUserHiddenItem {
	@SerializedName("hidden_at")
	private Instant hiddenAt;
	private TraktHiddenItemType type;
	private TraktMovieImpl movie;
	private TraktShowImpl show;
	private TraktSeasonImpl season;

	@Override
	public Instant getHiddenAt() {
		return hiddenAt;
	}

	@Override
	public void setHiddenAt(Instant hiddenAt) {
		this.hiddenAt = hiddenAt;
	}

	@Override
	public TraktUserHiddenItem withHiddenAt(Instant hiddenAt) {
		this.hiddenAt = hiddenAt;
		return this;
	}

	@Override
	public TraktHiddenItemType getType() {
		return type;
	}

	@Override
	public void setType(TraktHiddenItemType type) {
		this.type = type;
	}

	@Override
	public TraktUserHiddenItem withType(TraktHiddenItemType type) {
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
	public TraktUserHiddenItem withMovie(TraktMovieImpl movie) {
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
	public TraktUserHiddenItem withShow(TraktShowImpl show) {
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
	public TraktUserHiddenItem withSeason(TraktSeasonImpl season) {
		this.season = season;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserHiddenItemImpl that = (TraktUserHiddenItemImpl) o;

		if (hiddenAt != null ? !hiddenAt.equals(that.hiddenAt) : that.hiddenAt != null) return false;
		if (type != that.type) return false;
		if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
		if (show != null ? !show.equals(that.show) : that.show != null) return false;
		return season != null ? season.equals(that.season) : that.season == null;
	}

	@Override
	public int hashCode() {
		int result = hiddenAt != null ? hiddenAt.hashCode() : 0;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		result = 31 * result + (season != null ? season.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserHiddenItem{" + "hiddenAt=" + hiddenAt + ", type=" + type + ", movie=" + movie + ", show=" + show + ", season=" + season + '}';
	}
}
