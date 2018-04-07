package media.thehoard.thirdparty.api.trakt.objects.get.ratings.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktRatingsItemType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.ratings.TraktRatingsItem
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

data class TraktRatingsItemImpl(
        @SerializedName("rated_at")
        override var ratedAt: ZonedDateTime? = null,
        override var rating: Int? = null,
        override var type: TraktRatingsItemType = TraktRatingsItemType.UNSPECIFIED,
        override var movie: TraktMovieImpl? = null,
        override var show: TraktShowImpl? = null,
        override var season: TraktSeasonImpl? = null,
        override var episode: TraktEpisodeImpl? = null
) : TraktRatingsItem
