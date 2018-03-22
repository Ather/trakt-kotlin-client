package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl;

import java.util.Date;

public class TraktSyncRatingsPostEpisodeImpl {
	@SerializedName("rated_at")
	private Date ratedAt;
	private Integer rating;
	private TraktEpisodeIdsImpl ids;
}
