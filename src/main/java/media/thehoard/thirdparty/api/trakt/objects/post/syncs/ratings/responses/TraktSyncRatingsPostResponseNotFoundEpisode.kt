package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl

interface TraktSyncRatingsPostResponseNotFoundEpisode {
    var rating: Int?
    var ids: TraktEpisodeIdsImpl
}