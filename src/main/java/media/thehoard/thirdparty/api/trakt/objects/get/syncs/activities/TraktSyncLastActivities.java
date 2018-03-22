package media.thehoard.thirdparty.api.trakt.objects.get.syncs.activities;

import java.util.Date;

public interface TraktSyncLastActivities {
	Date getAll();

	void setAll(Date all);

	TraktSyncLastActivities withAll(Date all);

	TraktSyncMoviesLastActivities getMovies();

	void setMovies(TraktSyncMoviesLastActivities movies);

	TraktSyncLastActivities withMovies(TraktSyncMoviesLastActivities movies);

	TraktSyncEpisodesLastActivities getEpisodes();

	void setEpisodes(TraktSyncEpisodesLastActivities episodes);

	TraktSyncLastActivities withEpisodes(TraktSyncEpisodesLastActivities episodes);

	TraktSyncShowsLastActivities getShows();

	void setShows(TraktSyncShowsLastActivities shows);

	TraktSyncLastActivities withShows(TraktSyncShowsLastActivities shows);

	TraktSyncSeasonsLastActivities getSeasons();

	void setSeasons(TraktSyncSeasonsLastActivities seasons);

	TraktSyncLastActivities withSeasons(TraktSyncSeasonsLastActivities seasons);

	TraktSyncCommentsLastActivities getComments();

	void setComments(TraktSyncCommentsLastActivities comments);

	TraktSyncLastActivities withComments(TraktSyncCommentsLastActivities comments);

	TraktSyncListsLastActivities getLists();

	void setLists(TraktSyncListsLastActivities lists);

	TraktSyncLastActivities withLists(TraktSyncListsLastActivities lists);
}
