package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.extensions.isPositive
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktSharingImpl
import media.thehoard.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import media.thehoard.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import media.thehoard.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations.*
import media.thehoard.thirdparty.api.trakt.objects.post.comments.responses.implementations.TraktCommentPostResponseImpl
import media.thehoard.thirdparty.api.trakt.requests.comments.*
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import media.thehoard.thirdparty.api.trakt.responses.TraktNoContentResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import media.thehoard.thirdparty.api.trakt.responses.TraktResponse
import java.util.concurrent.CompletableFuture

class TraktCommentsModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getCommentAsync(
            commentId: Int
    ): CompletableFuture<TraktResponse<TraktCommentImpl>> {
        commentId.validate("comment id", ::isPositive)
        return RequestHandler(client).executeSingleItemRequestAsync(CommentSummaryRequest(id = commentId.toString()))
    }

    fun getMultipleCommentsAsync(
            commentIds: List<Int>
    ): CompletableFuture<List<TraktResponse<TraktCommentImpl>>> {
        if (commentIds.isEmpty())
            return CompletableFuture.completedFuture(listOf())

        var i = 0
        val tasks = Array(commentIds.size, { getCommentAsync(commentIds[i++]) })

        return CompletableFuture.supplyAsync {
            i = 0
            List(tasks.size, { tasks[i++].get() })
        }
    }

    fun postMovieCommentAsync(
            movie: TraktMovieImpl,
            comment: String,
            containsSpoiler: Boolean? = null,
            sharing: TraktSharingImpl? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktCommentPostResponseImpl>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentPostRequest(
                requestBody = TraktMovieCommentPostImpl(
                        movie = TraktMovieImpl(
                                title = movie.title,
                                year = movie.year,
                                ids = movie.ids
                        ),
                        comment = comment,
                        spoiler = containsSpoiler,
                        sharing = sharing
                )
        ), requestAuthorization)
    }

    fun postShowCommentAsync(
            show: TraktShowImpl,
            comment: String,
            containsSpoiler: Boolean? = null,
            sharing: TraktSharingImpl? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktCommentPostResponseImpl>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentPostRequest(
                requestBody = TraktShowCommentPostImpl(
                        show = TraktShowImpl(
                                title = show.title,
                                ids = show.ids
                        ),
                        comment = comment,
                        spoiler = containsSpoiler,
                        sharing = sharing
                )
        ), requestAuthorization)
    }

    fun postSeasonCommentAsync(
            season: TraktSeasonImpl,
            comment: String,
            containsSpoiler: Boolean? = null,
            sharing: TraktSharingImpl? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktCommentPostResponseImpl>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentPostRequest(
                requestBody = TraktSeasonCommentPostImpl(
                        season = TraktSeasonImpl(ids = season.ids),
                        comment = comment,
                        spoiler = containsSpoiler,
                        sharing = sharing
                )
        ), requestAuthorization)
    }

    fun postEpisodeCommentAsync(
            episode: TraktEpisodeImpl,
            comment: String,
            containsSpoiler: Boolean? = null,
            sharing: TraktSharingImpl? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktCommentPostResponseImpl>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentPostRequest(
                requestBody = TraktEpisodeCommentPostImpl(
                        episode = TraktEpisodeImpl(ids = episode.ids),
                        comment = comment,
                        spoiler = containsSpoiler,
                        sharing = sharing
                )
        ), requestAuthorization)
    }

    fun postListCommentAsync(
            list: TraktListImpl,
            comment: String,
            containsSpoiler: Boolean? = null,
            sharing: TraktSharingImpl? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktCommentPostResponseImpl>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentPostRequest(
                requestBody = TraktListCommentPostImpl(
                        list = TraktListImpl(ids = list.ids),
                        comment = comment,
                        spoiler = containsSpoiler,
                        sharing = sharing
                )
        ), requestAuthorization)
    }

    fun updateCommentAsync(
            commentId: Int,
            comment: String,
            containsSpoiler: Boolean? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktCommentPostResponseImpl>> {
        commentId.validate("comment id", ::isPositive)
        return RequestHandler(client).executeSingleItemRequestAsync(CommentUpdateRequest(
                id = commentId.toString(),
                requestBody = TraktCommentUpdatePostImpl(
                        comment = comment,
                        spoiler = containsSpoiler
                )
        ), requestAuthorization)
    }

    fun postCommentReplyAsync(
            commentId: Int,
            comment: String,
            containsSpoiler: Boolean? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktResponse<TraktCommentPostResponseImpl>> {
        commentId.validate("comment id", ::isPositive)
        return RequestHandler(client).executeSingleItemRequestAsync(CommentReplyRequest(
                id = commentId.toString(),
                requestBody = TraktCommentReplyPostImpl(
                        comment = comment,
                        spoiler = containsSpoiler
                )
        ), requestAuthorization)
    }

    fun deleteCommentAsync(
            commentId: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktNoContentResponse> {
        commentId.validate("comment id", ::isPositive)
        return RequestHandler(client).executeNoContentRequestAsync(CommentDeleteRequest(commentId.toString()), requestAuthorization)
    }

    fun likeCommentAsync(
            commentId: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktNoContentResponse> {
        commentId.validate("comment id", ::isPositive)
        return RequestHandler(client).executeNoContentRequestAsync(CommentLikeRequest(commentId.toString()), requestAuthorization)
    }

    fun unlikeCommentAsync(
            commentId: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktNoContentResponse> {
        commentId.validate("comment id", ::isPositive)
        return RequestHandler(client).executeNoContentRequestAsync(CommentUnlikeRequest(commentId.toString()), requestAuthorization)
    }

    fun getCommentRepliesAsync(
            commentId: Int,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktCommentImpl>> {
        commentId.validate("comment id", ::isPositive)
        return RequestHandler(client).executePagedRequestAsync(CommentRepliesRequest(
                id = commentId.toString(),
                page = pagedParameters?.page,
                limit = pagedParameters?.limit
        ), requestAuthorization)
    }
}
