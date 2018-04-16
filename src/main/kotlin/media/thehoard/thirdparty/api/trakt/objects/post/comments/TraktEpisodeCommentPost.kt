package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode

interface TraktEpisodeCommentPost : TraktCommentPost {
    var episode: TraktEpisode
}
