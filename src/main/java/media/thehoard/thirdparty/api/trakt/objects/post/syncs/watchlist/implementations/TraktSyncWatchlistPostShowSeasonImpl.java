package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations;

import java.util.List;

public class TraktSyncWatchlistPostShowSeasonImpl {
	private int number;
	private List<TraktSyncWatchlistPostShowEpisodeImpl> episodes;

	public TraktSyncWatchlistPostShowSeasonImpl(int season) {
		this.number = season;
	}
}
