package media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.responses.*
import media.thehoard.thirdparty.api.trakt.objects.post.users.customlistitems.responses.TraktUserCustomListItemsPostResponseNotFoundGroup

data class TraktUserCustomListItemsPostResponseNotFoundGroupImpl(
        override var movies: List<TraktPostResponseNotFoundMovie> = listOf(),
        override var shows: List<TraktPostResponseNotFoundShow> = listOf(),
        override var seasons: List<TraktPostResponseNotFoundSeason> = listOf(),
        override var episodes: List<TraktPostResponseNotFoundEpisode> = listOf(),
        override var people: List<TraktPostResponseNotFoundPerson> = listOf()
) : TraktUserCustomListItemsPostResponseNotFoundGroup
