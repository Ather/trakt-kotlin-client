package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.TraktSyncHistoryPostMovie
import java.time.ZonedDateTime

data class TraktSyncHistoryPostMovieImpl(
        @SerializedName("watched_at") override var watchedAt: ZonedDateTime? = null,
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktMovieIdsImpl = TraktMovieIdsImpl()
) : TraktSyncHistoryPostMovie
