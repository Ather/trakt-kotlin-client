package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations

import media.thehoard.thirdparty.api.trakt.extensions.validateComment
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktCommentReplyPost
import media.thehoard.thirdparty.api.trakt.utils.Json

data class TraktCommentReplyPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null
) : TraktCommentReplyPost {
    override fun toJson(): String = Json.serialize(this)

    override fun validate(variableName: String) = comment.validateComment()
}
