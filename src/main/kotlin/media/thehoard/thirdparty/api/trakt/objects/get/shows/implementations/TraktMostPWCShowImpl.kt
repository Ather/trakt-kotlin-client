package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktMostPWCShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

data class TraktMostPWCShowImpl(
        @SerializedName("watcher_count")
        override var watcherCount: Int? = null,
        @SerializedName("play_count")
        override var playCount: Int? = null,
        @SerializedName("collected_count")
        override var collectedCount: Int? = null,
        @SerializedName("collector_count")
        override var collectorCount: Int? = null,
        override var show: TraktShow = TraktShowImpl()
) : TraktMostPWCShow, TraktShow by show
