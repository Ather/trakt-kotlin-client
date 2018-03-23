package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl;

import java.time.Instant;

public class TraktSyncRatingsPostEpisodeImpl {
	@SerializedName("rated_at")
	private Instant ratedAt;
	private Integer rating;
	private TraktEpisodeIdsImpl ids;
}
