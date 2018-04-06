package media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShow
import java.time.ZonedDateTime

data class TraktWatchedShowImpl(
        override var plays: Int? = null,
        @SerializedName("last_watched_at")
        override var lastWatchedAt: ZonedDateTime? = null,
        override var show: TraktShowImpl = TraktShowImpl(),
        override var seasons: MutableList<TraktWatchedShowSeasonImpl> = mutableListOf()
) : TraktWatchedShow
