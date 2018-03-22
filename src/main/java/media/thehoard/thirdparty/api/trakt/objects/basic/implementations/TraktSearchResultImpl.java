package media.thehoard.thirdparty.api.trakt.objects.basic.implementations;

import media.thehoard.thirdparty.api.trakt.enums.TraktSearchResultType;
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSearchResult;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList;

public class TraktSearchResultImpl implements TraktSearchResult {
	private TraktSearchResultType type;
	private Float score;
	private TraktMovieImpl movie;
	private TraktShowImpl show;
	private TraktEpisodeImpl episode;
	private TraktPersonImpl person;
	private TraktList list;

	@Override
	public TraktSearchResultType getType() {
		return type;
	}

	@Override
	public void setType(TraktSearchResultType type) {
		this.type = type;
	}

	@Override
	public TraktSearchResult withType(TraktSearchResultType type) {
		this.type = type;
		return this;
	}

	@Override
	public Float getScore() {
		return score;
	}

	@Override
	public void setScore(Float score) {
		this.score = score;
	}

	@Override
	public TraktSearchResult withScore(Float score) {
		this.score = score;
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
	public TraktSearchResult withMovie(TraktMovieImpl movie) {
		this.movie = movie;
		return this;
	}

	@Override
	public TraktShow getShow() {
		return show;
	}

	@Override
	public void setShow(TraktShowImpl show) {
		this.show = show;
	}

	@Override
	public TraktSearchResult withShow(TraktShowImpl show) {
		this.show = show;
		return this;
	}

	@Override
	public TraktEpisode getEpisode() {
		return episode;
	}

	@Override
	public void setEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
	}

	@Override
	public TraktSearchResult withEpisode(TraktEpisodeImpl episode) {
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
	public TraktSearchResult withPerson(TraktPersonImpl person) {
		this.person = person;
		return this;
	}

	@Override
	public TraktList getList() {
		return list;
	}

	@Override
	public void setList(TraktList list) {
		this.list = list;
	}

	@Override
	public TraktSearchResult withList(TraktList list) {
		this.list = list;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktSearchResultImpl that = (TraktSearchResultImpl) o;

		return type == that.type && (score != null ? score.equals(that.score) : that.score == null) && (movie != null
				? movie.equals(that.movie) : that.movie == null) && (show != null ? show.equals(that.show)
				: that.show == null) && (episode != null ? episode.equals(that.episode) : that.episode == null) && (
				person != null ? person.equals(that.person) : that.person == null) && (list != null ? list
				.equals(that.list) : that.list == null);
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (score != null ? score.hashCode() : 0);
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		result = 31 * result + (episode != null ? episode.hashCode() : 0);
		result = 31 * result + (person != null ? person.hashCode() : 0);
		result = 31 * result + (list != null ? list.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktSearchResult{" + "type=" + type + ", score=" + score + ", movie=" + movie + ", show=" + show + ", episode=" + episode + ", person=" + person + ", list=" + list + '}';
	}
}
