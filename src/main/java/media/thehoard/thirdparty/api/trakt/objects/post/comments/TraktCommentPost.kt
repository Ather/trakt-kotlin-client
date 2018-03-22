package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl

interface TraktCommentPost {
    var comment: String

    var spoiler: Boolean?

    var sharing: TraktSharingImpl
}
