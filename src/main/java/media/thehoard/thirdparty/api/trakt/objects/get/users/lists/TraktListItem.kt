package media.thehoard.thirdparty.api.trakt.objects.get.users.lists

import media.thehoard.thirdparty.api.trakt.enums.TraktListItemType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

interface TraktListItem {
    var rank: String

    var listedAt: ZonedDateTime?

    var type: TraktListItemType

    var movie: TraktMovieImpl

    var show: TraktShowImpl

    var season: TraktSeasonImpl

    var episode: TraktEpisodeImpl

    var person: TraktPersonImpl

}
