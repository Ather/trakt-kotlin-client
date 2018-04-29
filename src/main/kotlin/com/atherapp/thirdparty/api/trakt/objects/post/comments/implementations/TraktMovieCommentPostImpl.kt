package com.atherapp.thirdparty.api.trakt.objects.post.comments.implementations

import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.post.comments.TraktMovieCommentPost

data class TraktMovieCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharing? = null,
        override var movie: TraktMovie = TraktMovieImpl()
) : TraktMovieCommentPost {
    override fun validate(variableName: String) {
        super.validate(variableName)
        movie.validate()
    }
}
