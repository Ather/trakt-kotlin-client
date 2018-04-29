package com.atherapp.thirdparty.api.trakt.objects.post.comments.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.post.comments.TraktEpisodeCommentPost

data class TraktEpisodeCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharing? = null,
        override var episode: TraktEpisode = TraktEpisodeImpl()
) : TraktEpisodeCommentPost {
    override fun validate(variableName: String) {
        super.validate(variableName)
        episode.validate()
    }
}
