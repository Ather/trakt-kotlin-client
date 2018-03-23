package media.thehoard.thirdparty.api.trakt.objects.get.syncs.playback;

import media.thehoard.thirdparty.api.trakt.enums.TraktSyncType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.time.Instant;

public interface TraktSyncPlaybackProgressItem {
	int getId();

	void setId(int id);

	TraktSyncPlaybackProgressItem withId(int id);

	Float getProgress();

	void setProgress(Float progress);

	TraktSyncPlaybackProgressItem withProgress(Float progress);

	Instant getPausedAt();

	void setPausedAt(Instant pausedAt);

	TraktSyncPlaybackProgressItem withPausedAt(Instant pausedAt);

	TraktSyncType getType();

	void setType(TraktSyncType type);

	TraktSyncPlaybackProgressItem withType(TraktSyncType type);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktSyncPlaybackProgressItem withMovie(TraktMovieImpl movie);

	TraktEpisodeImpl getEpisode();

	void setEpisode(TraktEpisodeImpl episode);

	TraktSyncPlaybackProgressItem withEpisode(TraktEpisodeImpl episode);

	TraktShowImpl getShow();

	void setShow(TraktShowImpl show);

	TraktSyncPlaybackProgressItem withShow(TraktShowImpl show);
}
