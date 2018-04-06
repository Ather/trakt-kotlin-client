package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.enums.TraktHiddenItemType
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import java.time.ZonedDateTime

interface TraktUserHiddenItem {
    var hiddenAt: ZonedDateTime?

    var type: TraktHiddenItemType

    var movie: TraktMovieImpl

    var show: TraktShowImpl

    var season: TraktSeasonImpl

}
