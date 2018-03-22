package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations;

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl;

public class TraktSyncWatchlistPostEpisodeImpl {
	private TraktEpisodeIdsImpl ids;

	public TraktSyncWatchlistPostEpisodeImpl() {}

	public TraktSyncWatchlistPostEpisodeImpl(TraktEpisodeIds ids) {
		this.ids = ids;
	}
}
