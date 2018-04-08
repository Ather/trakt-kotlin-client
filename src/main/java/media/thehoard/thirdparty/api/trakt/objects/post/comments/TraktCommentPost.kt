package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.extensions.validateComment
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktCommentPost : IRequestBody {
    var comment: String

    var spoiler: Boolean?

    var sharing: TraktSharingImpl?

    override fun validate(variableName: String) = comment.validateComment()
}
