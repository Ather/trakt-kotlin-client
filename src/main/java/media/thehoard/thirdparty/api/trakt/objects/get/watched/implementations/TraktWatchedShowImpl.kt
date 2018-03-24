package media.thehoard.thirdparty.api.trakt.objects.get.watched.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShow
import media.thehoard.thirdparty.api.trakt.objects.get.watched.TraktWatchedShowSeason

import java.time.Instant

data class TraktWatchedShowImpl(
        override var plays: Int? = null,
        @SerializedName("last_watched_at") override var lastWatchedAt: Instant? = null,
        override var show: TraktShowImpl = TraktShowImpl(),
        override var seasons: List<TraktWatchedShowSeasonImpl> = listOf()
) : TraktWatchedShow
