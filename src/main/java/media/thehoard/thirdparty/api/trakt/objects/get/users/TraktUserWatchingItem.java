package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.enums.TraktHistoryActionType;
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.time.Instant;

public interface TraktUserWatchingItem {
	Instant getStartedAt();

	void setStartedAt(Instant startedAt);

	TraktUserWatchingItem withStartedAt(Instant startedAt);

	Instant getExpiresAt();

	void setExpiresAt(Instant expiresAt);

	TraktUserWatchingItem withExpiresAt(Instant expiresAt);

	TraktHistoryActionType getAction();

	void setAction(TraktHistoryActionType action);

	TraktUserWatchingItem withAction(TraktHistoryActionType action);

	TraktSyncType getType();

	void setType(TraktSyncType type);

	TraktUserWatchingItem withType(TraktSyncType type);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktUserWatchingItem withMovie(TraktMovieImpl movie);

	TraktShowImpl getShow();

	void setShow(TraktShowImpl show);

	TraktUserWatchingItem withShow(TraktShowImpl show);

	TraktEpisodeImpl getEpisode();

	void setEpisode(TraktEpisodeImpl episode);

	TraktUserWatchingItem withEpisode(TraktEpisodeImpl episode);
}
