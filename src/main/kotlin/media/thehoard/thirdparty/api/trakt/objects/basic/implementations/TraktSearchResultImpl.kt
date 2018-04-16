package media.thehoard.thirdparty.api.trakt.objects.basic.implementations

import media.thehoard.thirdparty.api.trakt.enums.TraktSearchResultType
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSearchResult
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPerson
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList

data class TraktSearchResultImpl(
        override var type: TraktSearchResultType = TraktSearchResultType.UNSPECIFIED,
        override var score: Float? = null,
        override var movie: TraktMovie? = null,
        override var show: TraktShow? = null,
        override var episode: TraktEpisode? = null,
        override var person: TraktPerson? = null,
        override var list: TraktList? = null
) : TraktSearchResult
