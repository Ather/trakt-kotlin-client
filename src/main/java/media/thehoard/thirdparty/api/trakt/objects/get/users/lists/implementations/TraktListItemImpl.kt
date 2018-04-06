package media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktListItemType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktListItem
import java.time.ZonedDateTime

data class TraktListItemImpl(
        override var rank: String = "",
        @SerializedName("listed_at") override var listedAt: ZonedDateTime? = null,
        override var type: TraktListItemType = TraktListItemType.UNSPECIFIED,
        override var movie: TraktMovieImpl = TraktMovieImpl(),
        override var show: TraktShowImpl = TraktShowImpl(),
        override var season: TraktSeasonImpl = TraktSeasonImpl(),
        override var episode: TraktEpisodeImpl = TraktEpisodeImpl(),
        override var person: TraktPersonImpl = TraktPersonImpl()
) : TraktListItem
