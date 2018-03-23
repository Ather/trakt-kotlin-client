package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.enums.TraktHiddenItemType;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.time.Instant;

public interface TraktUserHiddenItem {
	Instant getHiddenAt();

	void setHiddenAt(Instant hiddenAt);

	TraktUserHiddenItem withHiddenAt(Instant hiddenAt);

	TraktHiddenItemType getType();

	void setType(TraktHiddenItemType type);

	TraktUserHiddenItem withType(TraktHiddenItemType type);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktUserHiddenItem withMovie(TraktMovieImpl movie);

	TraktShowImpl getShow();

	void setShow(TraktShowImpl show);

	TraktUserHiddenItem withShow(TraktShowImpl show);

	TraktSeasonImpl getSeason();

	void setSeason(TraktSeasonImpl season);

	TraktUserHiddenItem withSeason(TraktSeasonImpl season);
}
