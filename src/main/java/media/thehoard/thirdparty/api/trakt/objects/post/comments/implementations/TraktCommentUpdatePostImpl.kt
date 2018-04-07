package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations

import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktCommentUpdatePost
import media.thehoard.thirdparty.api.trakt.utils.Json

data class TraktCommentUpdatePostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null
) : TraktCommentUpdatePost {
    override fun toJson(): String = Json.serialize(this)

    override fun validate() {}
}
