package media.thehoard.thirdparty.api.trakt.requests.comments

import media.thehoard.thirdparty.api.trakt.extensions.containsSpace
import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktCommentImpl
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.base.RequestObjectType
import media.thehoard.thirdparty.api.trakt.requests.interfaces.IHasId
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsPagination

internal class CommentRepliesRequest(
        override var id: String,
        override var page: Int? = null,
        override var limit: Int? = null
) : AGetRequestHasResponse<TraktCommentImpl>(), IHasId, ISupportsPagination {

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriTemplate: String = "comments/{id}/replies{?page,limit}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf<String, String>().apply {
            this["id"] = id

            if (page != null)
                this["page"] = page!!.toString()

            if (limit != null)
                this["limit"] = limit!!.toString()
        }

    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("comment id not valid")
    }
}

internal class CommentSummaryRequest(
        override var id: String
) : AGetRequestHasResponse<TraktCommentImpl>(), IHasId {
    override val uriTemplate: String = "comments/{id}"

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf("id" to id)

    override fun validate() {
        if (id.isBlank() || id.containsSpace())
            throw IllegalArgumentException("comment id not valid")
    }
}