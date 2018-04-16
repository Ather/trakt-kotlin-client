package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktPersonMovieCreditsCastItem {
    var character: String

    var movie: TraktMovie

}
