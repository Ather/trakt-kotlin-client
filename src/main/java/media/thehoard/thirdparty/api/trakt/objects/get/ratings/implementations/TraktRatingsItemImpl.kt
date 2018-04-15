package media.thehoard.thirdparty.api.trakt.objects.get.ratings.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktRatingsItemType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.ratings.TraktRatingsItem
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

data class TraktRatingsItemImpl(
        @SerializedName("rated_at")
        override var ratedAt: ZonedDateTime? = null,
        override var rating: Int? = null,
        override var type: TraktRatingsItemType = TraktRatingsItemType.UNSPECIFIED,
        override var movie: TraktMovie? = null,
        override var show: TraktShow? = null,
        override var season: TraktSeason? = null,
        override var episode: TraktEpisode? = null
) : TraktRatingsItem
