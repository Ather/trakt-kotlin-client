package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.TraktSyncRatingsPostResponseNotFoundEpisode

data class TraktSyncRatingsPostResponseNotFoundEpisodeImpl(
        override var rating: Int? = null,
        override var ids: TraktEpisodeIdsImpl = TraktEpisodeIdsImpl()
) : TraktSyncRatingsPostResponseNotFoundEpisode
