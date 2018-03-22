package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations;

import media.thehoard.thirdparty.api.trakt.enums.TraktObjectType;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserComment;
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList;

public class TraktUserCommentImpl implements media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserComment {
	private TraktObjectType type;
	private TraktCommentImpl comment;
	private TraktMovieImpl movie;
	private TraktShowImpl show;
	private TraktSeasonImpl season;
	private TraktEpisodeImpl episode;
	private TraktList list;

	@Override
	public TraktObjectType getType() {
		return type;
	}

	@Override
	public void setType(TraktObjectType type) {
		this.type = type;
	}

	@Override
	public TraktUserComment withType(TraktObjectType type) {
		this.type = type;
		return this;
	}

	@Override
	public TraktCommentImpl getComment() {
		return comment;
	}

	@Override
	public void setComment(TraktCommentImpl comment) {
		this.comment = comment;
	}

	@Override
	public TraktUserComment withComment(TraktCommentImpl comment) {
		this.comment = comment;
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
	public TraktUserComment withMovie(TraktMovieImpl movie) {
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
	public TraktUserComment withShow(TraktShowImpl show) {
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
	public TraktUserComment withSeason(TraktSeasonImpl season) {
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
	public TraktUserComment withEpisode(TraktEpisodeImpl episode) {
		this.episode = episode;
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
	public TraktUserComment withList(TraktList list) {
		this.list = list;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TraktUserCommentImpl that = (TraktUserCommentImpl) o;

		if (type != that.type) return false;
		if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
		if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;
		if (show != null ? !show.equals(that.show) : that.show != null) return false;
		if (season != null ? !season.equals(that.season) : that.season != null) return false;
		if (episode != null ? !episode.equals(that.episode) : that.episode != null) return false;
		return list != null ? list.equals(that.list) : that.list == null;
	}

	@Override
	public int hashCode() {
		int result = type != null ? type.hashCode() : 0;
		result = 31 * result + (comment != null ? comment.hashCode() : 0);
		result = 31 * result + (movie != null ? movie.hashCode() : 0);
		result = 31 * result + (show != null ? show.hashCode() : 0);
		result = 31 * result + (season != null ? season.hashCode() : 0);
		result = 31 * result + (episode != null ? episode.hashCode() : 0);
		result = 31 * result + (list != null ? list.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TraktUserComment{" + "type=" + type + ", comment=" + comment + ", movie=" + movie + ", show=" + show + ", season=" + season + ", episode=" + episode + ", list=" + list + '}';
	}
}
