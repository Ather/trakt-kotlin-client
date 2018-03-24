package media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShowEpisode

import java.time.Instant

data class TraktWatchedShowEpisodeImpl(
        override var number: Int? = null,
        override var plays: Int? = null,
        @SerializedName("last_watched_at") override var lastWatchedAt: Instant? = null
) : TraktWatchedShowEpisode
