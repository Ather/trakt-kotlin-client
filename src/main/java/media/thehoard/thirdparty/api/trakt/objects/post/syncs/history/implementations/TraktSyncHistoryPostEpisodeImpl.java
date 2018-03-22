package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl;

import java.util.Date;

public class TraktSyncHistoryPostEpisodeImpl {
	@SerializedName("watched_at")
	private Date watchedAt;
	private TraktEpisodeIdsImpl ids;
}
