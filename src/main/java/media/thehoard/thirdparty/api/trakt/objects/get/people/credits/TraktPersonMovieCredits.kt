package media.thehoard.thirdparty.api.trakt.objects.get.people.credits

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsCastItemImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsCrewImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations.TraktPersonMovieCreditsImpl

interface TraktPersonMovieCredits {
    var cast: List<TraktPersonMovieCreditsCastItemImpl>

    var crew: TraktPersonMovieCreditsCrewImpl

}
