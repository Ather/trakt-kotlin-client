package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

interface TraktEpisodeScrobblePost : TraktScrobblePost {
    var episode: TraktEpisode

    var show: TraktShow?
}