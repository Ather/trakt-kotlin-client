package com.atherapp.thirdparty.api.trakt.objects.post.comments

import com.atherapp.thirdparty.api.trakt.extensions.validateComment
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktCommentUpdatePost : IRequestBody {
    var comment: String

    var spoiler: Boolean?

    override fun validate(variableName: String) = comment.validateComment()
}
