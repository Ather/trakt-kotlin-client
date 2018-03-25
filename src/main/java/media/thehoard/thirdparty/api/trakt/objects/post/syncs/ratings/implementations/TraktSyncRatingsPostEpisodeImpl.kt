package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostEpisode

import java.time.Instant

data class TraktSyncRatingsPostEpisodeImpl(
        override var ids: TraktEpisodeIdsImpl = TraktEpisodeIdsImpl(),
        override var rating: Int? = null,
        @SerializedName("rated_at")
        override var ratedAt: Instant? = null
) : TraktSyncRatingsPostEpisode
