package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

interface TraktPersonMovieCreditsCastItem {
    var character: String

    var movie: TraktMovieImpl

}
