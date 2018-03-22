package media.thehoard.thirdparty.api.trakt.objects.post.syncs.collection.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl;
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl;

import java.util.Date;
import java.util.List;

public class TraktSyncCollectionPostShowImpl {
	@SerializedName("collected_at")
	private Date collectedAt;
	private String title;
	private Integer year;
	private TraktShowIdsImpl ids;
	private List<TraktSyncCollectionPostShowSeasonImpl> seasons;
	private TraktMetadataImpl metadata;
}
