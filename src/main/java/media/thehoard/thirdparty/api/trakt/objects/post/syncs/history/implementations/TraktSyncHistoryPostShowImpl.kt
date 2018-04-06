package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostShow
import java.time.ZonedDateTime

data class TraktSyncHistoryPostShowImpl(
        @SerializedName("watched_at")
        override var watchedAt: ZonedDateTime? = null,
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktShowIdsImpl = TraktShowIdsImpl(),
        override var seasons: MutableList<TraktSyncHistoryPostShowSeasonImpl> = mutableListOf()
) : TraktSyncHistoryPostShow
