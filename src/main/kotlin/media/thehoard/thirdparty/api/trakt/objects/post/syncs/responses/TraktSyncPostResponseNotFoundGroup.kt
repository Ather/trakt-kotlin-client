package media.thehoard.thirdparty.api.trakt.objects.post.syncs.responses

import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundEpisode
import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundMovie
import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundSeason
import media.thehoard.thirdparty.api.trakt.objects.post.responses.TraktPostResponseNotFoundShow

interface TraktSyncPostResponseNotFoundGroup {
    var movies: List<TraktPostResponseNotFoundMovie>
    var shows: List<TraktPostResponseNotFoundShow>
    var seasons: List<TraktPostResponseNotFoundSeason>
    var episodes: List<TraktPostResponseNotFoundEpisode>
}