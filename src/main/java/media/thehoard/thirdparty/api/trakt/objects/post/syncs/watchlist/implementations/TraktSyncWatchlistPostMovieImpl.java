package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl;

public class TraktSyncWatchlistPostMovieImpl {
	private String title;
	private Integer year;
	private TraktMovieIdsImpl ids;

	public TraktSyncWatchlistPostMovieImpl() {}

	public TraktSyncWatchlistPostMovieImpl(TraktMovieIds ids, String title, Integer year) {
		this.ids = ids;
		this.title = title;
		this.year = year;
	}
}
