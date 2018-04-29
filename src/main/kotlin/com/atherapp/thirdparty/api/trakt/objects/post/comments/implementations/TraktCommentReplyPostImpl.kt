package com.atherapp.thirdparty.api.trakt.objects.post.comments.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.comments.TraktCommentReplyPost

data class TraktCommentReplyPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null
) : TraktCommentReplyPost
