package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.enums.TraktObjectType;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList;

public interface TraktUserComment {
	TraktObjectType getType();

	void setType(TraktObjectType type);

	TraktUserComment withType(TraktObjectType type);

	TraktCommentImpl getComment();

	void setComment(TraktCommentImpl comment);

	TraktUserComment withComment(TraktCommentImpl comment);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktUserComment withMovie(TraktMovieImpl movie);

	TraktShowImpl getShow();

	void setShow(TraktShowImpl show);

	TraktUserComment withShow(TraktShowImpl show);

	TraktSeasonImpl getSeason();

	void setSeason(TraktSeasonImpl season);

	TraktUserComment withSeason(TraktSeasonImpl season);

	TraktEpisodeImpl getEpisode();

	void setEpisode(TraktEpisodeImpl episode);

	TraktUserComment withEpisode(TraktEpisodeImpl episode);

	TraktList getList();

	void setList(TraktList list);

	TraktUserComment withList(TraktList list);
}
