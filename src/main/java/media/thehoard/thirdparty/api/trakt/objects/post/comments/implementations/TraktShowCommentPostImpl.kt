package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktShowCommentPost

data class TraktShowCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharingImpl = TraktSharingImpl(),
        override var show: TraktShowImpl = TraktShowImpl()
) : TraktShowCommentPost
