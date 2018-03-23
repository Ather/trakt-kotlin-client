package media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.enums.TraktListItemType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktListItem;

import java.time.Instant;

public class TraktListItemImpl implements TraktListItem {
	private String rank;
	@SerializedName("listed_at")
	private Instant listedAt;
	private TraktListItemType type;
	private TraktMovieImpl movie;
	private TraktShowImpl show;
	private TraktSeasonImpl season;
	private TraktEpisodeImpl episode;
	private TraktPersonImpl person;

	@Override
	public String getRank() {
		return rank;
	}

	@Override
	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public TraktListItem withRank(String rank) {
		this.rank = rank;
		return this;
	}

	@Override
	public Instant getListedAt() {
		return listedAt;
	}

	@Override
	public void setListedAt(Instant listedAt) {
		this.listedAt = listedAt;
	}

	@Override
	public TraktListItem withListedAt(Instant listedAt) {
		this.listedAt = listedAt;
		return this;
	}

	@Override
	public TraktListItemType getType() {
		return type;
	}

	@Override
	public void setType(TraktListItemType type) {
		this.type = type;
	}

	@Override
	public TraktListItem withType(TraktListItemType type) {
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
	public TraktListItem withMovie(TraktMovieImpl movie) {
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
	public TraktListItem withShow(TraktShowImpl show) {
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
	public TraktListItem withSeason(TraktSeasonImpl season) {
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
	public TraktListItem withEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
		return this;
	}

	@Override
	public TraktPersonImpl getPerson() {
		return person;
	}

	@Override
	public void setPerson(TraktPersonImpl person) {
		this.person = person;
	}

	@Override
	public TraktListItem withPerson(TraktPersonImpl person) {
		this.person = person;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktListItemImpl that = (TraktListItemImpl) o;

		if (rank != null ? !rank.equals(that.rank) : that.rank != null) return false;
		if (listedAt != null ? !listedAt.equals(that.listedAt) : that.listedAt != null) return false;
		if (type != that.type) return false;
		if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
		if (show != null ? !show.equals(that.show) : that.show != null) return false;
		if (season != null ? !season.equals(that.season) : that.season != null) return false;
		if (episode != null ? !episode.equals(that.episode) : that.episode != null) return false;
		return person != null ? person.equals(that.person) : that.person == null;
	}

	@Override
	public int hashCode() {
		int result = rank != null ? rank.hashCode() : 0;
		result = 31 * result + (listedAt != null ? listedAt.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		result = 31 * result + (season != null ? season.hashCode() : 0);
		result = 31 * result + (episode != null ? episode.hashCode() : 0);
		result = 31 * result + (person != null ? person.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktListItem{" + "rank='" + rank + '\'' + ", listedAt=" + listedAt + ", type=" + type + ", movie=" + movie + ", show=" + show + ", season=" + season + ", episode=" + episode + ", person=" + person + '}';
	}
}
