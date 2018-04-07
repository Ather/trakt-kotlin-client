package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.enums.TraktSearchResultType
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSearchResult
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.people.implementations.TraktPersonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList

data class TraktSearchResultImpl(
        override var type: TraktSearchResultType = TraktSearchResultType.UNSPECIFIED,
        override var score: Float? = null,
        override var movie: TraktMovieImpl? = null,
        override var show: TraktShowImpl? = null,
        override var episode: TraktEpisodeImpl? = null,
        override var person: TraktPersonImpl? = null,
        override var list: TraktList? = null
) : TraktSearchResult
