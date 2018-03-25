package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostEpisode

import java.time.Instant

data class TraktSyncHistoryPostEpisodeImpl(
        @SerializedName("watched_at") override var watchedAt: Instant? = null,
        override var ids: TraktEpisodeIdsImpl = TraktEpisodeIdsImpl()
) : TraktSyncHistoryPostEpisode
