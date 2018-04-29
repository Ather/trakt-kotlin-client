package com.atherapp.thirdparty.api.trakt.objects.post.comments.implementations

import com.atherapp.thirdparty.api.trakt.objects.post.comments.TraktCommentUpdatePost

data class TraktCommentUpdatePostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null
) : TraktCommentUpdatePost
