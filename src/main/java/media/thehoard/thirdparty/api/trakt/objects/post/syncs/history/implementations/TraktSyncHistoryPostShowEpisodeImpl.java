package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.post.PostHistoryEpisodes;

import java.time.Instant;

public class TraktSyncHistoryPostShowEpisodeImpl {
	@SerializedName("watched_at")
	private Instant watchedAt;
	private int number;

	public TraktSyncHistoryPostShowEpisodeImpl(PostHistoryEpisodes.PostHistoryEpisode episode) {
		this.number = episode.number;
		this.watchedAt = episode.watchedAt;
	}
}
