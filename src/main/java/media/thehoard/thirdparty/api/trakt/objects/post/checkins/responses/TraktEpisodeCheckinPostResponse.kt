package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktEpisodeCheckinPostResponse : TraktCheckinPostResponse {
    var episode: TraktEpisode

    var show: TraktShow

}
