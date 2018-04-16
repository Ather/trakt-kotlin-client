package media.thehoard.thirdparty.api.trakt.objects.get.users

import media.thehoard.thirdparty.api.trakt.enums.TraktHiddenItemType
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

interface TraktUserHiddenItem {
    var hiddenAt: ZonedDateTime?

    var type: TraktHiddenItemType

    var movie: TraktMovie?

    var show: TraktShow?

    var season: TraktSeason?

}
