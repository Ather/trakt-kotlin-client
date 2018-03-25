package media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses

import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.post.responses.implementations.TraktPostResponseNotFoundShowImpl

interface TraktSyncPostResponseNotFoundGroup {
    var movies: List<TraktPostResponseNotFoundMovieImpl>
    var shows: List<TraktPostResponseNotFoundShowImpl>
    var seasons: List<TraktPostResponseNotFoundSeasonImpl>
    var episodes: List<TraktPostResponseNotFoundEpisodeImpl>
}