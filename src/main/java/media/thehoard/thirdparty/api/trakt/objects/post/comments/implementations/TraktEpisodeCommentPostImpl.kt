package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktEpisodeCommentPost

data class TraktEpisodeCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharingImpl = TraktSharingImpl(),
        override var episode: TraktEpisodeImpl = TraktEpisodeImpl()
) : TraktEpisodeCommentPost
