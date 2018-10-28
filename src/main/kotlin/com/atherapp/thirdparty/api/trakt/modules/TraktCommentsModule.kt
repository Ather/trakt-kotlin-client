package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.objects.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktComment
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSharing
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.TraktEpisode
import com.atherapp.thirdparty.api.trakt.objects.get.episodes.implementations.TraktEpisodeImpl
import com.atherapp.thirdparty.api.trakt.objects.get.movies.TraktMovie
import com.atherapp.thirdparty.api.trakt.objects.get.movies.implementations.TraktMovieImpl
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.TraktSeason
import com.atherapp.thirdparty.api.trakt.objects.get.seasons.implementations.TraktSeasonImpl
import com.atherapp.thirdparty.api.trakt.objects.get.shows.TraktShow
import com.atherapp.thirdparty.api.trakt.objects.get.shows.implementations.TraktShowImpl
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.implementations.TraktListImpl
import com.atherapp.thirdparty.api.trakt.objects.post.comments.implementations.*
import com.atherapp.thirdparty.api.trakt.objects.post.comments.responses.TraktCommentPostResponse
import com.atherapp.thirdparty.api.trakt.requests.comments.*
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import com.atherapp.thirdparty.api.trakt.responses.TraktNoContentResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import com.atherapp.thirdparty.api.trakt.responses.TraktResponse
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class TraktCommentsModule internal constructor(override val client: TraktClient) : TraktModule {
    fun getCommentAsync(
            commentId: Int
    ): Deferred<TraktResponse<TraktComment>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentSummaryRequest(commentId.toString()))
    }

    fun getMultipleCommentsAsync(
            commentIds: List<Int>
    ): Deferred<List<TraktResponse<TraktComment>>> {
        if (commentIds.isEmpty())
            return CompletableDeferred(listOf())

        var i = 0
        val tasks = Array(commentIds.size) { getCommentAsync(commentIds[i++]) }

        return GlobalScope.async { tasks.map { it.await() } }
    }

    fun postMovieCommentAsync(
            movie: TraktMovie,
            comment: String,
            containsSpoiler: Boolean? = null,
            sharing: TraktSharing? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktCommentPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentPostRequest(TraktMovieCommentPostImpl(
                comment, containsSpoiler, sharing,
                TraktMovieImpl(
                        movie.title,
                        movie.year,
                        movie.ids
                )
        )), requestAuthorization)
    }

    fun postShowCommentAsync(
            show: TraktShow,
            comment: String,
            containsSpoiler: Boolean? = null,
            sharing: TraktSharing? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktCommentPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentPostRequest(TraktShowCommentPostImpl(
                comment, containsSpoiler, sharing,
                TraktShowImpl(
                        show.title,
                        show.year,
                        show.ids
                )
        )), requestAuthorization)
    }

    fun postSeasonCommentAsync(
            season: TraktSeason,
            comment: String,
            containsSpoiler: Boolean? = null,
            sharing: TraktSharing? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktCommentPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentPostRequest(TraktSeasonCommentPostImpl(
                comment, containsSpoiler, sharing,
                TraktSeasonImpl(ids = season.ids)
        )), requestAuthorization)
    }

    fun postEpisodeCommentAsync(
            episode: TraktEpisode,
            comment: String,
            containsSpoiler: Boolean? = null,
            sharing: TraktSharing? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktCommentPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentPostRequest(TraktEpisodeCommentPostImpl(
                comment, containsSpoiler, sharing,
                TraktEpisodeImpl(ids = episode.ids)
        )), requestAuthorization)
    }

    fun postListCommentAsync(
            list: TraktList,
            comment: String,
            containsSpoiler: Boolean? = null,
            sharing: TraktSharing? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktCommentPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentPostRequest(TraktListCommentPostImpl(
                comment, containsSpoiler, sharing,
                TraktListImpl(ids = list.ids)
        )), requestAuthorization)
    }

    fun updateCommentAsync(
            commentId: Int,
            comment: String,
            containsSpoiler: Boolean? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktCommentPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentUpdateRequest(
                commentId.toString(),
                TraktCommentUpdatePostImpl(
                        comment,
                        containsSpoiler
                )
        ), requestAuthorization)
    }

    fun postCommentReplyAsync(
            commentId: Int,
            comment: String,
            containsSpoiler: Boolean? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktResponse<TraktCommentPostResponse>> {
        return RequestHandler(client).executeSingleItemRequestAsync(CommentReplyRequest(
                commentId.toString(),
                TraktCommentReplyPostImpl(
                        comment,
                        containsSpoiler
                )
        ), requestAuthorization)
    }

    fun deleteCommentAsync(
            commentId: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(CommentDeleteRequest(commentId.toString()), requestAuthorization)
    }

    fun likeCommentAsync(
            commentId: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(CommentLikeRequest(commentId.toString()), requestAuthorization)
    }

    fun unlikeCommentAsync(
            commentId: Int,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktNoContentResponse> {
        return RequestHandler(client).executeNoContentRequestAsync(CommentUnlikeRequest(commentId.toString()), requestAuthorization)
    }

    fun getCommentRepliesAsync(
            commentId: Int,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktPagedResponse<TraktComment>> {
        return RequestHandler(client).executePagedRequestAsync(CommentRepliesRequest(
                commentId.toString(),
                pagedParameters?.page,
                pagedParameters?.limit
        ), requestAuthorization)
    }
}
