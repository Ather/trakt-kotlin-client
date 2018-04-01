package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations.TraktSyncWatchlistPostEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations.TraktSyncWatchlistPostMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist.implementations.TraktSyncWatchlistPostShowImpl
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktSyncWatchlistPost : IRequestBody {
    var movies: MutableList<TraktSyncWatchlistPostMovieImpl>
    var shows: MutableList<TraktSyncWatchlistPostShowImpl>
    var episodes: MutableList<TraktSyncWatchlistPostEpisodeImpl>
}