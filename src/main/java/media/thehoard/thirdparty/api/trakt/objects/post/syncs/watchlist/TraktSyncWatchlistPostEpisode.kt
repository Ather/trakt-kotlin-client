package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeIdsImpl

interface TraktSyncWatchlistPostEpisode {
    var ids: TraktEpisodeIdsImpl
}