package media.thehoard.thirdparty.api.trakt.objects.post.comments.responses

import media.thehoard.thirdparty.api.trakt.objects.basic.TraktComment
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl

interface TraktCommentPostResponse : TraktComment {
    var sharing: TraktSharingImpl
}