package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

interface TraktEpisodeScrobblePost : TraktScrobblePost {
    var episode: TraktEpisodeImpl

    var show: TraktShowImpl
}