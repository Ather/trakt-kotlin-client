package media.thehoard.thirdparty.api.trakt.objects.get.people.credits.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.credits.TraktPersonMovieCreditsCastItem

data class TraktPersonMovieCreditsCastItemImpl(
        override var character: String = "",
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktPersonMovieCreditsCastItem
