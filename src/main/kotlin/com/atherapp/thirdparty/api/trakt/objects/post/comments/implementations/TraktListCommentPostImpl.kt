package com.atherapp.thirdparty.api.trakt.objects.post.comments.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
import com.atherapp.thirdparty.api.trakt.objects.post.comments.TraktListCommentPost

data class TraktListCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharing? = null,
        override var list: TraktList = TraktListImpl()
) : TraktListCommentPost {
    override fun validate(variableName: String) {
        super.validate(variableName)
        list.validate()
    }
}
