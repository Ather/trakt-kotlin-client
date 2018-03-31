package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponseNotFoundGroup

data class TraktUserCustomListItemsPostResponseNotFoundGroupImpl(
        override var movies: List<TraktPostResponseNotFoundMovieImpl> = listOf(),
        override var shows: List<TraktPostResponseNotFoundShowImpl> = listOf(),
        override var seasons: List<TraktPostResponseNotFoundSeasonImpl> = listOf(),
        override var episodes: List<TraktPostResponseNotFoundEpisodeImpl> = listOf(),
        override var people: List<TraktPostResponseNotFoundPersonImpl> = listOf()
) : TraktUserCustomListItemsPostResponseNotFoundGroup
