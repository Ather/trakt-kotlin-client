package media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundEpisode
import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundMovie
import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundSeason
import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundShow
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseNotFoundGroup

data class TraktSyncPostResponseNotFoundGroupImpl(
        override var movies: List<TraktPostResponseNotFoundMovie> = listOf(),
        override var shows: List<TraktPostResponseNotFoundShow> = listOf(),
        override var seasons: List<TraktPostResponseNotFoundSeason> = listOf(),
        override var episodes: List<TraktPostResponseNotFoundEpisode> = listOf()
) : TraktSyncPostResponseNotFoundGroup
