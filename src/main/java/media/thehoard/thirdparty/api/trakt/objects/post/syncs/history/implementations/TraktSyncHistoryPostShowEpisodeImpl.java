package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.post.PostHistoryEpisodes;

import java.util.Date;

public class TraktSyncHistoryPostShowEpisodeImpl {
	@SerializedName("watched_at")
	private Date watchedAt;
	private int number;

	public TraktSyncHistoryPostShowEpisodeImpl(PostHistoryEpisodes.PostHistoryEpisode episode) {
		this.number = episode.number;
		this.watchedAt = episode.watchedAt;
	}
}
