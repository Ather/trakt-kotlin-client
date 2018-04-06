package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShow
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

data class TraktCollectionShowImpl<ConcreteEpisodeType : TraktCollectionShowEpisode>(
        @SerializedName("last_collected_at")
        override var lastCollectedAt: ZonedDateTime? = null,
        override var show: TraktShowImpl = TraktShowImpl(),
        override var seasons: MutableList<TraktCollectionShowSeasonImpl<ConcreteEpisodeType>> = mutableListOf()
) : TraktCollectionShow<ConcreteEpisodeType>, TraktShow by show
