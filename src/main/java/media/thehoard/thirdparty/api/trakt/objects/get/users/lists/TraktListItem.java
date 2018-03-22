package media.thehoard.thirdparty.api.trakt.objects.get.users.lists;

import media.thehoard.thirdparty.api.trakt.enums.TraktListItemType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.util.Date;

public interface TraktListItem {
	String getRank();

	void setRank(String rank);

	TraktListItem withRank(String rank);

	Date getListedAt();

	void setListedAt(Date listedAt);

	TraktListItem withListedAt(Date listedAt);

	TraktListItemType getType();

	void setType(TraktListItemType type);

	TraktListItem withType(TraktListItemType type);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktListItem withMovie(TraktMovieImpl movie);

	TraktShowImpl getShow();

	void setShow(TraktShowImpl show);

	TraktListItem withShow(TraktShowImpl show);

	TraktSeasonImpl getSeason();

	void setSeason(TraktSeasonImpl season);

	TraktListItem withSeason(TraktSeasonImpl season);

	TraktEpisodeImpl getEpisode();

	void setEpisode(TraktEpisodeImpl episode);

	TraktListItem withEpisode(TraktEpisodeImpl episode);

	TraktPersonImpl getPerson();

	void setPerson(TraktPersonImpl person);

	TraktListItem withPerson(TraktPersonImpl person);
}
