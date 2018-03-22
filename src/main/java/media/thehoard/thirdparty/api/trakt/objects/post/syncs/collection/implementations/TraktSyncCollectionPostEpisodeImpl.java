package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl;

import java.util.Date;

public class TraktSyncCollectionPostEpisodeImpl {
	@SerializedName("collected_at")
	private Date collectedAt;
	private TraktEpisodeIdsImpl ids;
	private TraktMetadataImpl metadata;
}
