package media.thehoard.thirdparty.api.trakt.objects.post.syncs.watchlist

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieIds

interface TraktSyncWatchlistPostMovie {
    var title: String
    var year: Int?
    var ids: TraktMovieIds
}