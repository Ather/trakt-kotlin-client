package com.atherapp.thirdparty.api.trakt.requests.comments

import com.atherapp.thirdparty.api.trakt.extensions.isValidStringId
import com.atherapp.thirdparty.api.trakt.extensions.validate
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktComment
import com.atherapp.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import com.atherapp.thirdparty.api.trakt.requests.base.RequestObjectType
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IHasId
import com.atherapp.thirdparty.api.trakt.requests.interfaces.ISupportsPagination

internal class CommentRepliesRequest(
        override var id: String,
        override var page: Int? = null,
        override var limit: Int? = null
) : AGetRequestHasResponse<TraktComment>(TraktComment::class), IHasId, ISupportsPagination {

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

    override fun validate(variableName: String) = id.validate("comment id", ::isValidStringId)
}

internal class CommentSummaryRequest(
        override var id: String
) : AGetRequestHasResponse<TraktComment>(TraktComment::class), IHasId {
    override val uriTemplate: String = "comments/{id}"

    override val requestObjectType: RequestObjectType = RequestObjectType.Comments

    override val uriPathParameters: Map<String, Any>?
        get() = mapOf("id" to id)

    override fun validate(variableName: String) = id.validate("comment id", ::isValidStringId)
}