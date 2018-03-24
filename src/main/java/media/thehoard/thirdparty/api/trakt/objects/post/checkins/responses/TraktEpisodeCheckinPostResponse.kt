package media.thehoard.thirdparty.api.trakt.objects.post.checkins.responses

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

interface TraktEpisodeCheckinPostResponse : TraktCheckinPostResponse {
    var episode: TraktEpisodeImpl

    var show: TraktShowImpl

}
