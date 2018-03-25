package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostShowSeason

import java.time.Instant
import java.util.Date

data class TraktSyncHistoryPostShowSeasonImpl(
        @SerializedName("watched_at")
        override var watchedAt: Instant? = null,
        override var number: Int = 0,
        override var episodes: MutableList<TraktSyncHistoryPostShowEpisodeImpl> = mutableListOf()
) : TraktSyncHistoryPostShowSeason
