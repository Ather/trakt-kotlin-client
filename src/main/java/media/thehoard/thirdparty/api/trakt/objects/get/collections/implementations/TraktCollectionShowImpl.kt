package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

data class TraktCollectionShowImpl(
        @SerializedName("last_collected_at")
        override var lastCollectedAt: ZonedDateTime? = null,
        override var show: TraktShowImpl = TraktShowImpl(),
        override var seasons: MutableList<TraktCollectionShowSeasonImpl> = mutableListOf()
) : TraktCollectionShow, TraktShow by show
