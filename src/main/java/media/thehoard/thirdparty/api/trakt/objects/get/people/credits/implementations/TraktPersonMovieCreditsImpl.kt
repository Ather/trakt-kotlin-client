package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCredits

data class TraktPersonMovieCreditsImpl(
        override var cast: List<TraktPersonMovieCreditsCastItemImpl> = listOf(),
        override var crew: TraktPersonMovieCreditsCrewImpl = TraktPersonMovieCreditsCrewImpl()
) : TraktPersonMovieCredits
