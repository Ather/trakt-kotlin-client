package com.atherapp.thirdparty.api.trakt.requests.users

import com.atherapp.thirdparty.api.trakt.enums.TraktCommentSortOrder
import com.atherapp.thirdparty.api.trakt.extensions.isValidStringId
import com.atherapp.thirdparty.api.trakt.extensions.validate
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktComment
import com.atherapp.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import com.atherapp.thirdparty.api.trakt.requests.base.AuthorizationRequirement
import com.atherapp.thirdparty.api.trakt.requests.base.RequestObjectType
import com.atherapp.thirdparty.api.trakt.requests.interfaces.IHasId
import com.atherapp.thirdparty.api.trakt.requests.interfaces.ISupportsPagination

internal class UserListCommentsRequest(
        internal var username: String,
        override var id: String,
        internal var sortOrder: TraktCommentSortOrder?,
        override var page: Int?,
        override var limit: Int?
) : AGetRequestHasResponse<TraktComment>(TraktComment::class), IHasId, ISupportsPagination {

    override val authorizationRequirement: AuthorizationRequirement = AuthorizationRequirement.NotRequired

    override val requestObjectType: RequestObjectType = RequestObjectType.Lists

    override val uriTemplate: String = "users/{username}/lists/{id}/comments{/sort_order}{?page,limit}"

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf("username" to username, "id" to id).apply {
            if (sortOrder != null && sortOrder != TraktCommentSortOrder.UNSPECIFIED)
                this["sort_order"] = sortOrder!!.uriName
            if (page != null)
                this["page"] = page!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }

    override fun validate(variableName: String) {
        username.validate("username", ::isValidStringId)
        id.validate("list id", ::isValidStringId)
    }
}