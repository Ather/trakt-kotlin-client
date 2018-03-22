package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.responses.implementations;

import com.google.gson.annotations.SerializedName;
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseGroupImpl;
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations.TraktSyncPostResponseNotFoundGroupImpl;

public class TraktSyncWatchlistRemovePostResponseImpl {
	public TraktSyncPostResponseGroupImpl deleted;

	@SerializedName("not_found")
	public TraktSyncPostResponseNotFoundGroupImpl notFound;
}
