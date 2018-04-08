package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktListCommentPost

data class TraktListCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharingImpl? = null,
        override var list: TraktListImpl = TraktListImpl()
) : TraktListCommentPost {
    override fun validate(variableName: String) {
        super.validate(variableName)
        list.validate()
    }
}
