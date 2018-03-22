package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl;

import java.util.List;

public class TraktSyncWatchlistPostShowImpl {
	private String title;
	private Integer year;
	private TraktShowIdsImpl ids;
	private List<TraktSyncWatchlistPostShowSeasonImpl> seasons;

	public TraktSyncWatchlistPostShowImpl() {}

	public TraktSyncWatchlistPostShowImpl(TraktShowIdsImpl ids, String title, Integer year) {
		this.ids = ids;
		this.title = title;
		this.year = year;
	}
}
