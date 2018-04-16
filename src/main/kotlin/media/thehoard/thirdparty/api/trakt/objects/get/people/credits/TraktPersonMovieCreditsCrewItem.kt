package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktPersonMovieCreditsCrewItem {
    var job: String

    var movie: TraktMovie

}
