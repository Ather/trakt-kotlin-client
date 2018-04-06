package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostMovie
import java.time.ZonedDateTime

data class TraktSyncRatingsPostMovieImpl(
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktMovieIdsImpl = TraktMovieIdsImpl(),
        override var rating: Int? = null,
        @SerializedName("rated_at")
        override var ratedAt: ZonedDateTime? = null
) : TraktSyncRatingsPostMovie
