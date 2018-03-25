package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.post.PostHistoryEpisodes
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostShowEpisode

import java.time.Instant

data class TraktSyncHistoryPostShowEpisodeImpl(
        @SerializedName("watched_at")
        override var watchedAt: Instant? = null,
        override var number: Int = 0
) : TraktSyncHistoryPostShowEpisode
