package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie

data class TraktMovieImpl(override var title: String = "",
                          override var year: Int? = null,
                          override var ids: TraktMovieIdsImpl = TraktMovieIdsImpl()) : TraktMovie
