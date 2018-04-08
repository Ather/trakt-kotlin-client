package media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.history.responses.TraktSyncHistoryRemovePostResponseNotFoundGroup

class TraktSyncHistoryRemovePostResponseNotFoundGroupImpl(
        override var ids: List<Long> = listOf(),
        override var movies: List<TraktPostResponseNotFoundMovieImpl> = listOf(),
        override var shows: List<TraktPostResponseNotFoundShowImpl> = listOf(),
        override var seasons: List<TraktPostResponseNotFoundSeasonImpl> = listOf(),
        override var episodes: List<TraktPostResponseNotFoundEpisodeImpl> = listOf()
) : TraktSyncHistoryRemovePostResponseNotFoundGroup
