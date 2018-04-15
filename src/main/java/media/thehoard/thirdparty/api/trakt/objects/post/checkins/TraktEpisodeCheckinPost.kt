package media.thehoard.thirdparty.api.trakt.objects.post.checkins

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktEpisodeCheckinPost : TraktCheckinPost {
    var episode: TraktEpisode

    var show: TraktShow?
}
