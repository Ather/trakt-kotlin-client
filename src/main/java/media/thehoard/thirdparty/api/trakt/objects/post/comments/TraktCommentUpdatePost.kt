package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktCommentUpdatePost : IRequestBody {
    var comment: String

    var spoiler: Boolean?
}
