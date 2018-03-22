package media.thehoard.thirdparty.api.trakt.objects.get.users;

import media.thehoard.thirdparty.api.trakt.enums.TraktHistoryActionType;
import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.util.Date;

public interface TraktUserWatchingItem {
	Date getStartedAt();

	void setStartedAt(Date startedAt);

	TraktUserWatchingItem withStartedAt(Date startedAt);

	Date getExpiresAt();

	void setExpiresAt(Date expiresAt);

	TraktUserWatchingItem withExpiresAt(Date expiresAt);

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
