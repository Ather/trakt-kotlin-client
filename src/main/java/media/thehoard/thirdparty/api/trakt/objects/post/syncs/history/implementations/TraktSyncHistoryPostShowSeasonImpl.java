package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class TraktSyncHistoryPostShowSeasonImpl {
	@SerializedName("watched_at")
	private Instant watchedAt;
	private int number;
	private List<TraktSyncHistoryPostShowEpisodeImpl> episodes;

	public TraktSyncHistoryPostShowSeasonImpl(int number) {
		this.number = number;
	}
}
