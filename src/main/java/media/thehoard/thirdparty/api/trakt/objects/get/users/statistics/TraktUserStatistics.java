package media.thehoard.thirdparty.api.trakt.objects.get.users.statistics;

import media.thehoard.thirdparty.api.trakt.objects.get.users.statistics.implementations.*;

public interface TraktUserStatistics {
	TraktUserMoviesStatisticsImpl getMovies();

	void setMovies(TraktUserMoviesStatisticsImpl movies);

	TraktUserStatistics withMovies(TraktUserMoviesStatisticsImpl movies);

	TraktUserShowsStatisticsImpl getShows();

	void setShows(TraktUserShowsStatisticsImpl shows);

	TraktUserStatistics withShows(TraktUserShowsStatisticsImpl shows);

	TraktUserSeasonsStatisticsImpl getSeasons();

	void setSeasons(TraktUserSeasonsStatisticsImpl seasons);

	TraktUserStatistics withSeasons(TraktUserSeasonsStatisticsImpl seasons);

	TraktUserEpisodesStatisticsImpl getEpisodes();

	void setEpisodes(TraktUserEpisodesStatisticsImpl episodes);

	TraktUserStatistics withEpisodes(TraktUserEpisodesStatisticsImpl episodes);

	TraktUserNetworkStatisticsImpl getNetwork();

	void setNetwork(TraktUserNetworkStatisticsImpl network);

	TraktUserStatistics withNetwork(TraktUserNetworkStatisticsImpl network);

	TraktUserRatingsStatisticsImpl getRatings();

	void setRatings(TraktUserRatingsStatisticsImpl ratings);

	TraktUserStatistics withRatings(TraktUserRatingsStatisticsImpl ratings);
}
