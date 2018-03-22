package media.thehoard.thirdparty.api.trakt.objects.basic;

import media.thehoard.thirdparty.api.trakt.enums.TraktSearchResultType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList;

public interface TraktSearchResult {
	TraktSearchResultType getType();

	void setType(TraktSearchResultType type);

	Float getScore();

	void setScore(Float score);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktShow getShow();

	void setShow(TraktShowImpl show);

	TraktEpisode getEpisode();

	void setEpisode(TraktEpisodeImpl episode);

	TraktPersonImpl getPerson();

	void setPerson(TraktPersonImpl person);

	TraktList getList();

	void setList(TraktList list);
}
