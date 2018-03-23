package media.thehoard.thirdparty.api.trakt.objects.get.watchlist;

import media.thehoard.thirdparty.api.trakt.enums.TraktSyncItemType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.time.Instant;

public interface TraktWatchlistItem {
	Instant getListedAt();

	void setListedAt(Instant listedAt);

	TraktWatchlistItem withListedAt(Instant listedAt);

	TraktSyncItemType getType();

	void setType(TraktSyncItemType type);

	TraktWatchlistItem withType(TraktSyncItemType type);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktWatchlistItem withMovie(TraktMovieImpl movie);

	TraktShowImpl getShow();

	void setShow(TraktShowImpl show);

	TraktWatchlistItem withShow(TraktShowImpl show);

	TraktSeasonImpl getSeason();

	void setSeason(TraktSeasonImpl season);

	TraktWatchlistItem withSeason(TraktSeasonImpl season);

	TraktEpisodeImpl getEpisode();

	void setEpisode(TraktEpisodeImpl episode);

	TraktWatchlistItem withEpisode(TraktEpisodeImpl episode);
}
