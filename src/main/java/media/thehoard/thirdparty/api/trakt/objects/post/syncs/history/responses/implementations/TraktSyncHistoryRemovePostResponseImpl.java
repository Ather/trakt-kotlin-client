package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl;

public class TraktSyncHistoryRemovePostResponseImpl {
	private TraktSyncPostResponseGroupImpl deleted;
	@SerializedName("not_found")
	private TraktSyncPostResponseNotFoundGroupImpl notFound;
}
