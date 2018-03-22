package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl;

import java.util.Date;
import java.util.List;

public class TraktSyncHistoryPostShowImpl {
	@SerializedName("watched_at")
	private Date watchedAt;
	private String title;
	private Integer year;
	private TraktShowIdsImpl ids;
	private List<TraktSyncHistoryPostShowSeasonImpl> seasons;
}
