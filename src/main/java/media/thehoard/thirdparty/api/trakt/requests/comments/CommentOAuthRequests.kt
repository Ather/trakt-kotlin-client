package media.thehoard.thirdparty.api.trakt.requests.comments

import media.thehoard.thirdparty.api.trakt.extensions.isValidStringId
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktCommentReplyPost
import media.thehoard.thirdparty.api.trakt.objects.post.comments.TraktCommentUpdatePost
import media.thehoard.thirdparty.api.trakt.objects.post.comments.responses.TraktCommentPostResponse
import media.thehoard.thirdparty.api.trakt.requests.base.ABodylessPostRequest
import media.thehoard.thirdparty.api.trakt.requests.base.ADeleteRequest
import media.thehoard.thirdparty.api.trakt.requests.base.APostRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

internal class CommentDeleteRequest(
        override var id: String
) : ADeleteRequest(), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriTemplate: String = "comments/{id}"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf("id" to id)

    override fun validate(variableName: String) = id.validate("comment id", ::isValidStringId)
}

internal class CommentLikeRequest(
        override var id: String
) : ABodylessPostRequest(), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriTemplate: String = "comments/{id}/like"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf("id" to id)

    override fun validate(variableName: String) = id.validate("comment id", ::isValidStringId)
}

internal class CommentPostRequest<TRequestBodyType : IRequestBody>(
        override var requestBody: TRequestBodyType? = null
) : APostRequestHasResponse<TraktCommentPostResponse, TRequestBodyType>(TraktCommentPostResponse::class) {

    override val uriTemplate: String = "comments"

    override val uriPathParameters: Map<String, Any>? = mapOf()
}

internal class CommentReplyRequest(
        override var id: String,
        override var requestBody: TraktCommentReplyPost? = null
) : APostRequestHasResponse<TraktCommentPostResponse, TraktCommentReplyPost>(TraktCommentPostResponse::class), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriTemplate: String = "comments/{id}/replies"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf("id" to id)

    override fun validate(variableName: String) {
        super.validate(variableName)
        id.validate("comment id", ::isValidStringId)
    }
}

internal class CommentUnlikeRequest(
        override var id: String
) : ADeleteRequest(), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriTemplate: String = "comments/{id}/like"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf("id" to id)

    override fun validate(variableName: String) = id.validate("comment id", ::isValidStringId)
}

internal class CommentUpdateRequest(
        override var id: String,
        override var requestBody: TraktCommentUpdatePost? = null
) : APostRequestHasResponse<TraktCommentPostResponse, TraktCommentUpdatePost>(TraktCommentPostResponse::class), IHasId {

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriTemplate: String = "comments/{id}"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf("id" to id)

    override fun validate(variableName: String) {
        super.validate(variableName)
        id.validate("comment id", ::isValidStringId)
    }
}
