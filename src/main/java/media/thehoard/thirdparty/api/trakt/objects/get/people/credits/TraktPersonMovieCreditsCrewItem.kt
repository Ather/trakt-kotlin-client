package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

interface TraktPersonMovieCreditsCrewItem {
    var job: String

    var movie: TraktMovieImpl

}
