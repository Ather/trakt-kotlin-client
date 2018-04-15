package media.thehoard.thirdparty.api.trakt.objects.basic

import media.thehoard.thirdparty.api.trakt.enums.TraktSearchResultType
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie
import media.thehoard.thirdparty.api.trakt.objects.get.people.TraktPerson
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.TraktList

interface TraktSearchResult {
    var type: TraktSearchResultType

    var score: Float?

    var movie: TraktMovie?

    var show: TraktShow?

    var episode: TraktEpisode?

    var person: TraktPerson?

    var list: TraktList?
}
