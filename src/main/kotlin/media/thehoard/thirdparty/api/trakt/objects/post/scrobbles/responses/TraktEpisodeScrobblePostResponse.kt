package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.responses

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktEpisodeScrobblePostResponse : TraktScrobblePostResponse {
    var episode: TraktEpisode

    var show: TraktShow?
}