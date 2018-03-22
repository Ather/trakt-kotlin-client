package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class TraktSyncRatingsPostShowSeasonImpl {
	@SerializedName("rated_at")
	private Date ratedAt;
	private Integer rating;
	private int number;
	private List<TraktSyncRatingsPostShowEpisodeImpl> episodes;

	public TraktSyncRatingsPostShowSeasonImpl(int season) {
		this.number = season;
	}
}
