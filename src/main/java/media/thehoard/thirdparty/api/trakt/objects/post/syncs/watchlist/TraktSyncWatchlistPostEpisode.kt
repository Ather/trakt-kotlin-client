package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisodeIds

interface TraktSyncWatchlistPostEpisode {
    var ids: TraktEpisodeIds
}