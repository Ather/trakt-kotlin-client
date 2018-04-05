package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShowProgress

data class TraktShowProgressImpl(
        override var aired: Int? = null,
        override var completed: Int? = null,
        @SerializedName("hidden_seasons")
        override var hiddenSeasons: MutableList<TraktSeasonImpl> = mutableListOf(),
        @SerializedName("next_episode")
        override var nextEpisode: TraktEpisodeImpl = TraktEpisodeImpl(),
        @SerializedName("last_episode")
        override var lastEpisode: TraktEpisodeImpl = TraktEpisodeImpl()
) : TraktShowProgress
