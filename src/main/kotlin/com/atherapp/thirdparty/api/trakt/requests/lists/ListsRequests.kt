package com.atherapp.thirdparty.api.trakt.requests.lists

import com.atherapp.thirdparty.api.trakt.objects.get.users.lists.TraktList
import com.atherapp.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import com.atherapp.thirdparty.api.trakt.requests.interfaces.ISupportsPagination

internal abstract class AbstractListsRequest(
        override var page: Int?,
        override var limit: Int?
) : AGetRequestHasResponse<TraktList>(TraktList::class), ISupportsPagination {
    override val uriPathParameters: Map<String, String>?
        get() = hashMapOf<String, String>().apply {
            if (page != null)
                this["page"] = page!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }

    override fun validate(variableName: String) {}
}

internal class ListsPopularRequest(
        override var page: Int? = null,
        override var limit: Int? = null
) : AbstractListsRequest(page, limit) {
    override val uriTemplate: String = "lists/popular{?page,limit}"
}

internal class ListsTrendingRequest(
        override var page: Int? = null,
        override var limit: Int? = null
) : AbstractListsRequest(page, limit) {
    override val uriTemplate: String = "lists/trending{?page,limit}"
}