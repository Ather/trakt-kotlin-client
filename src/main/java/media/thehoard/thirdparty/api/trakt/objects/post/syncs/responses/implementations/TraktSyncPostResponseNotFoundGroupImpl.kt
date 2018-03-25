package media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses.TraktSyncPostResponseNotFoundGroup

data class TraktSyncPostResponseNotFoundGroupImpl(
        override var movies: List<TraktPostResponseNotFoundMovieImpl> = listOf(),
        override var shows: List<TraktPostResponseNotFoundShowImpl> = listOf(),
        override var seasons: List<TraktPostResponseNotFoundSeasonImpl> = listOf(),
        override var episodes: List<TraktPostResponseNotFoundEpisodeImpl> = listOf()
) : TraktSyncPostResponseNotFoundGroup
