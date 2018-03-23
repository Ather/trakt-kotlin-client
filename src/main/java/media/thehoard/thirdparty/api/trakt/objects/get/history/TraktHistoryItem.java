package media.thehoard.thirdparty.api.trakt.objects.get.history;

import media.thehoard.thirdparty.api.trakt.enums.TraktHistoryActionType;
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.time.Instant;

public interface TraktHistoryItem {
	long getId();

	void setId(long id);

	TraktHistoryItem withId(long id);

	Instant getWatchedAt();

	void setWatchedAt(Instant watchedAt);

	TraktHistoryItem withWatchedAt(Instant watchedAt);

	TraktHistoryActionType getAction();

	void setAction(TraktHistoryActionType action);

	TraktHistoryItem withAction(TraktHistoryActionType action);

	TraktSyncItemType getType();

	void setType(TraktSyncItemType type);

	TraktHistoryItem withType(TraktSyncItemType type);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktHistoryItem withMovie(TraktMovieImpl movie);

	TraktShowImpl getShow();

	void setShow(TraktShowImpl show);

	TraktHistoryItem withShow(TraktShowImpl show);

	TraktSeasonImpl getSeason();

	void setSeason(TraktSeasonImpl season);

	TraktHistoryItem withSeason(TraktSeasonImpl season);

	TraktEpisodeImpl getEpisode();

	void setEpisode(TraktEpisodeImpl episode);

	TraktHistoryItem withEpisode(TraktEpisodeImpl episode);
}
