package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostEpisode
import java.time.ZonedDateTime

data class TraktSyncHistoryPostEpisodeImpl(
        @SerializedName("watched_at") override var watchedAt: ZonedDateTime? = null,
        override var ids: TraktEpisodeIds = TraktEpisodeIdsImpl()
) : TraktSyncHistoryPostEpisode
