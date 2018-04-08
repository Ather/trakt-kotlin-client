package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktCommentUpdatePost

data class TraktCommentUpdatePostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null
) : TraktCommentUpdatePost
