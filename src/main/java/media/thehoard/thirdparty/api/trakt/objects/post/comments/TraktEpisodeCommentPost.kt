package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl

interface TraktEpisodeCommentPost : TraktCommentPost {
    var episode: TraktEpisodeImpl
}
