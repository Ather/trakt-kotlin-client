package media.thehoard.thirdparty.api.trakt.objects.post.comments.responses.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl

interface TraktCommentPostResponse {
    var sharing: TraktSharingImpl?
}

class TraktCommentPostResponseImpl : TraktCommentPostResponse {
    override var sharing: TraktSharingImpl? = null
}