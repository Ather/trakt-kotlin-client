package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations;

import java.util.List;

public class TraktSyncCollectionPostShowSeasonImpl {
	private int number;
	private List<TraktSyncCollectionPostShowEpisodeImpl> episodes;

	public TraktSyncCollectionPostShowSeasonImpl(int season) {
		this.number = season;
	}
}
