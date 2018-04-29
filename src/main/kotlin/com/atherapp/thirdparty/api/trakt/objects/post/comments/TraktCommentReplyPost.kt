package com.atherapp.thirdparty.api.trakt.objects.post.comments

import com.atherapp.thirdparty.api.trakt.extensions.validateComment

interface TraktCommentReplyPost : TraktCommentUpdatePost {
    override fun validate(variableName: String) = comment.validateComment()
}
