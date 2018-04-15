package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCredits
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCastItem
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCrew

data class TraktPersonMovieCreditsImpl(
        override var cast: List<TraktPersonMovieCreditsCastItem> = listOf(),
        override var crew: TraktPersonMovieCreditsCrew = TraktPersonMovieCreditsCrewImpl()
) : TraktPersonMovieCredits
