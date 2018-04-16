package media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses

import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations.TraktSyncRatingsPostResponseNotFoundEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations.TraktSyncRatingsPostResponseNotFoundMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations.TraktSyncRatingsPostResponseNotFoundSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.post.syncs.ratings.responses.implementations.TraktSyncRatingsPostResponseNotFoundShowImpl

interface TraktSyncRatingsPostResponseNotFoundGroup {
    var movies: MutableList<TraktSyncRatingsPostResponseNotFoundMovieImpl>
    var shows: MutableList<TraktSyncRatingsPostResponseNotFoundShowImpl>
    var seasons: MutableList<TraktSyncRatingsPostResponseNotFoundSeasonImpl>
    var episodes: MutableList<TraktSyncRatingsPostResponseNotFoundEpisodeImpl>
}