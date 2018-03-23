package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl;

import java.time.Instant;

public class TraktSyncHistoryPostEpisodeImpl {
	@SerializedName("watched_at")
	private Instant watchedAt;
	private TraktEpisodeIdsImpl ids;
}
