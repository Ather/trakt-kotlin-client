package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses

import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.*

interface TraktUserCustomListItemsPostResponseNotFoundGroup {
    var movies: List<TraktPostResponseNotFoundMovieImpl>
    var shows: List<TraktPostResponseNotFoundShowImpl>
    var seasons: List<TraktPostResponseNotFoundSeasonImpl>
    var episodes: List<TraktPostResponseNotFoundEpisodeImpl>
    var people: List<TraktPostResponseNotFoundPersonImpl>
}