package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.extensions.validateComment

interface TraktCommentReplyPost : TraktCommentUpdatePost {
    override fun validate(variableName: String) = comment.validateComment()
}
