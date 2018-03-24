package media.thehoard.thirdparty.api.trakt.objects.get.collections.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShow
import media.thehoard.thirdparty.api.trakt.objects.get.collections.TraktCollectionShowEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.Instant

data class TraktCollectionShowImpl<ConcreteEpisodeType : TraktCollectionShowEpisode>(
        @SerializedName("last_collected_at")
        override var lastCollectedAt: Instant? = null,
        override var show: TraktShowImpl = TraktShowImpl(),
        override var seasons: MutableList<TraktCollectionShowSeasonImpl<ConcreteEpisodeType>> = mutableListOf()
) : TraktCollectionShow<ConcreteEpisodeType> {

    override var title: String
        get() = show.title
        set(title) {
            show.title = title
        }

    override var year: Int?
        get() = show.year
        set(year) {
            show.year = year
        }

    override var ids: TraktShowIdsImpl
        get() = show.ids
        set(ids) {
            show.ids = ids
        }
}
