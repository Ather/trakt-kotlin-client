package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses

import media.thehoard.thirdparty.api.trakt.objects.post.responses.*

interface TraktUserCustomListItemsPostResponseNotFoundGroup {
    var movies: List<TraktPostResponseNotFoundMovie>
    var shows: List<TraktPostResponseNotFoundShow>
    var seasons: List<TraktPostResponseNotFoundSeason>
    var episodes: List<TraktPostResponseNotFoundEpisode>
    var people: List<TraktPostResponseNotFoundPerson>
}