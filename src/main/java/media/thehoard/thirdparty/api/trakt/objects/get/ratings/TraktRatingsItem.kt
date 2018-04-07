package media.thehoard.thirdparty.api.trakt.objects.get.ratings

import media.thehoard.thirdparty.api.trakt.enums.TraktRatingsItemType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

interface TraktRatingsItem {
    var ratedAt: ZonedDateTime?

    var rating: Int?

    var type: TraktRatingsItemType

    var movie: TraktMovieImpl?

    var show: TraktShowImpl?

    var season: TraktSeasonImpl?

    var episode: TraktEpisodeImpl?

}
