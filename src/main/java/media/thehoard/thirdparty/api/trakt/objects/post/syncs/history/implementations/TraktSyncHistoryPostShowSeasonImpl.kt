package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostShowEpisode
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostShowSeason
import java.time.ZonedDateTime

data class TraktSyncHistoryPostShowSeasonImpl(
        @SerializedName("watched_at")
        override var watchedAt: ZonedDateTime? = null,
        override var number: Int = 0,
        override var episodes: MutableList<TraktSyncHistoryPostShowEpisode> = mutableListOf()
) : TraktSyncHistoryPostShowSeason
