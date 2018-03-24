package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsCastItemImpl

interface TraktPersonMovieCreditsCastItem {
    var character: String

    var movie: TraktMovieImpl

}
