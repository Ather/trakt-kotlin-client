package media.thehoard.thirdparty.api.trakt.requests.comments

import media.thehoard.thirdparty.api.trakt.extensions.containsSpace
import media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations.TraktCommentReplyPostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.implementations.TraktCommentUpdatePostImpl
import media.thehoard.thirdparty.api.trakt.objects.post.comments.responses.implementations.TraktCommentPostResponseImpl
import media.thehoard.thirdparty.api.trakt.requests.base.ABodylessPostRequest
import media.thehoard.thirdparty.api.trakt.requests.base.ADeleteRequest
import media.thehoard.thirdparty.api.trakt.requests.base.APostRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IRequestBody

internal class CommentDeleteRequest : ADeleteRequest(), IHasId {
    override var id: String = ""

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriTemplate: String = "comments/{id}"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf("id" to id)

    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("comment id not valid")
    }
}

internal class CommentLikeRequest : ABodylessPostRequest(), IHasId {
    override var id: String = ""

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriTemplate: String = "comments/{id}/like"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf("id" to id)

    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("comment id not valid")
    }
}

internal class CommentPostRequest<TRequestBodyType : IRequestBody> : APostRequestHasResponse<TraktCommentPostResponseImpl, TRequestBodyType>() {
    override var requestBody: TRequestBodyType? = null

    override val uriTemplate: String = "comments"

    override val uriPathParameters: Map<String, Any>? = mapOf()
}

internal class CommentReplyPost : APostRequestHasResponse<TraktCommentPostResponseImpl, TraktCommentReplyPostImpl>(), IHasId {
    override var id: String = ""

    override var requestBody: TraktCommentReplyPostImpl? = null

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriTemplate: String = "comments/{id}/replies"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf("id" to id)

    override fun validate() {
        super.validate()

        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("comment id not valid")
    }
}

internal class CommentUnlikeRequest : ADeleteRequest(), IHasId {
    override var id: String = ""

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriTemplate: String = "comments/{id}/like"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf("id" to id)

    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("comment id not valid")
    }
}

internal class CommentUpdateRequest : APostRequestHasResponse<TraktCommentPostResponseImpl, TraktCommentUpdatePostImpl>(), IHasId {
    override var id: String = ""

    override var requestBody: TraktCommentUpdatePostImpl? = null

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriTemplate: String = "comments/{id}"

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf("id" to id)

    override fun validate() {
        super.validate()

        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("comment id not valid")
    }
}
