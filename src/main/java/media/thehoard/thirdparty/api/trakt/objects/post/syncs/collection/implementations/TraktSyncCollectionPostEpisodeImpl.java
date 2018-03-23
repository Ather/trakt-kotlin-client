package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl;

import java.time.Instant;

public class TraktSyncCollectionPostEpisodeImpl {
	@SerializedName("collected_at")
	private Instant collectedAt;
	private TraktEpisodeIdsImpl ids;
	private TraktMetadataImpl metadata;
}
