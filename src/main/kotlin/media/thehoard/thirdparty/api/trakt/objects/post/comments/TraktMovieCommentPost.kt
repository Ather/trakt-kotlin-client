package media.thehoard.thirdparty.api.trakt.objects.post.comments

import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovie

interface TraktMovieCommentPost : TraktCommentPost {
    var movie: TraktMovie
}
