package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktMetadata;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds;
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl;

import java.util.Date;

public class TraktSyncCollectionPostMovieImpl {
	@SerializedName("collected_at")
	private Date collectedAt;
	private String title;
	private Integer year;
	private TraktMovieIdsImpl ids;
	private TraktMetadataImpl metadata;
}
