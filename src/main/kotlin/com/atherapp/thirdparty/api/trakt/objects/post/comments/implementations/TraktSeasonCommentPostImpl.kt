package com.atherapp.thirdparty.api.trakt.objects.post.comments.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import com.atherapp.thirdparty.api.trakt.objects.post.comments.TraktSeasonCommentPost

data class TraktSeasonCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharing? = null,
        override var season: TraktSeason = TraktSeasonImpl()
) : TraktSeasonCommentPost {
    override fun validate(variableName: String) {
        super.validate(variableName)
        season.validate()
    }
}
