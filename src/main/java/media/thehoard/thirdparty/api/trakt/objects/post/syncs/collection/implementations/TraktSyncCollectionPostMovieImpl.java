package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl;

import java.time.Instant;

public class TraktSyncCollectionPostMovieImpl {
	@SerializedName("collected_at")
	private Instant collectedAt;
	private String title;
	private Integer year;
	private TraktMovieIdsImpl ids;
	private TraktMetadataImpl metadata;
}
