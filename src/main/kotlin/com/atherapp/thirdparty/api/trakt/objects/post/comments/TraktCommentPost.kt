package com.atherapp.thirdparty.api.trakt.objects.post.comments

import com.atherapp.thirdparty.api.trakt.extensions.validateComment
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IRequestBody

interface TraktCommentPost : IRequestBody {
    var comment: String

    var spoiler: Boolean?

    var sharing: TraktSharing?

    override fun validate(variableName: String) = comment.validateComment()
}
