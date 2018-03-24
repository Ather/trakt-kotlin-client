package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCrewItem

data class TraktPersonMovieCreditsCrewItemImpl(
        override var job: String = "",
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktPersonMovieCreditsCrewItem
