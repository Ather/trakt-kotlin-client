package media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeWatchedProgress

import java.time.Instant

data class TraktEpisodeWatchedProgressImpl(override var number: Int? = null,
                                           override var completed: Boolean? = null,
                                           @SerializedName("last_watched_at")
                                           override var lastWatchedAt: Instant? = null) : TraktEpisodeWatchedProgress
