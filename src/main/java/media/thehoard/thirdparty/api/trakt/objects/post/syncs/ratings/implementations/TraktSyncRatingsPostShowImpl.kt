package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.TraktSyncRatingsPostShow

import java.time.Instant

data class TraktSyncRatingsPostShowImpl(
        override var title: String = "",
        override var year: Int? = null,
        override var ids: TraktShowIdsImpl = TraktShowIdsImpl(),
        override var rating: Int? = null,
        @SerializedName("rated_at")
        override var ratedAt: Instant? = null,
        override var seasons: MutableList<TraktSyncRatingsPostShowSeasonImpl> = mutableListOf()
) : TraktSyncRatingsPostShow
