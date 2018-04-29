package com.atherapp.thirdparty.api.trakt.objects.post.comments.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import com.atherapp.thirdparty.api.trakt.objects.post.comments.TraktShowCommentPost

data class TraktShowCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharing? = null,
        override var show: TraktShow = TraktShowImpl()
) : TraktShowCommentPost {
    override fun validate(variableName: String) {
        super.validate(variableName)
        show.validate()
    }
}
