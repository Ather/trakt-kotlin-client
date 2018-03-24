package media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktMovieCommentPost

data class TraktMovieCommentPostImpl(
        override var comment: String = "",
        override var spoiler: Boolean? = null,
        override var sharing: TraktSharingImpl = TraktSharingImpl(),
        override var movie: TraktMovieImpl = TraktMovieImpl()
) : TraktMovieCommentPost
