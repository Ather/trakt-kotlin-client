package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSharing
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktEpisodeCommentPost

data class TraktEpisodeCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharing? = null,
        override var episode: TraktEpisode = TraktEpisodeImpl()
) : TraktEpisodeCommentPost {
    override fun validate(variableName: String) {
        super.validate(variableName)
        episode.validate()
    }
}
