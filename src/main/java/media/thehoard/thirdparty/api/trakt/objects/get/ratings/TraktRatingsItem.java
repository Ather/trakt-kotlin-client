package media.thehoard.thirdparty.api.trakt.objects.get.ratings;

import media.thehoard.thirdparty.api.trakt.enums.TraktRatingsItemType;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl;

import java.time.Instant;

public interface TraktRatingsItem {
	Instant getRatedAt();

	void setRatedAt(Instant ratedAt);

	TraktRatingsItem withRatedAt(Instant ratedAt);

	Integer getRating();

	void setRating(Integer rating);

	TraktRatingsItem withRating(Integer rating);

	TraktRatingsItemType getType();

	void setType(TraktRatingsItemType type);

	TraktRatingsItem withType(TraktRatingsItemType type);

	TraktMovieImpl getMovie();

	void setMovie(TraktMovieImpl movie);

	TraktRatingsItem withMovie(TraktMovieImpl movie);

	TraktShowImpl getShow();

	void setShow(TraktShowImpl show);

	TraktRatingsItem withShow(TraktShowImpl show);

	TraktSeasonImpl getSeason();

	void setSeason(TraktSeasonImpl season);

	TraktRatingsItem withSeason(TraktSeasonImpl season);

	TraktEpisodeImpl getEpisode();

	void setEpisode(TraktEpisodeImpl episode);

	TraktRatingsItem withEpisode(TraktEpisodeImpl episode);
}
