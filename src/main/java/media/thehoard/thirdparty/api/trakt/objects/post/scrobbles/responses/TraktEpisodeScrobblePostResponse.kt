package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

interface TraktEpisodeScrobblePostResponse : TraktScrobblePostResponse {
    var episode: TraktEpisodeImpl

    var show: TraktShowImpl?
}