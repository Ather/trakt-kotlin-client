package media.thehoard.thirdparty.api.trakt.objects.post.checkins

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl

interface TraktEpisodeCheckinPost : TraktCheckinPost {
    var episode: TraktEpisodeImpl

    var show: TraktShowImpl
}
