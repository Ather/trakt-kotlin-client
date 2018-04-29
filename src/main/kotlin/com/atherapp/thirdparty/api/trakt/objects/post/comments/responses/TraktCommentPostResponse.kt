package com.atherapp.thirdparty.api.trakt.objects.post.comments.responses

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktComment
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing

interface TraktCommentPostResponse : TraktComment {
    var sharing: TraktSharing
}