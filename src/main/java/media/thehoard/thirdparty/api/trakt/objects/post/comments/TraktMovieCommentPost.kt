package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl

interface TraktMovieCommentPost : TraktCommentPost<TraktMovieCommentPost> {
    var movie: TraktMovieImpl

    fun withMovie(movie: TraktMovieImpl): TraktMovieCommentPost
}
