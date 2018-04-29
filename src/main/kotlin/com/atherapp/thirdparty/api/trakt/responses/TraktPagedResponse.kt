package com.atherapp.thirdparty.api.trakt.responses

import com.atherapp.thirdparty.api.trakt.responses.interfaces.ITraktPagedResponse
import kotlin.reflect.KClass

class TraktPagedResponse<TResponseContentType>(responseContentClass: KClass<*>) : TraktListResponse<TResponseContentType>(responseContentClass), ITraktPagedResponse<TResponseContentType> {
    override var pageCount: Int? = null

    override var itemCount: Int? = null

    override fun equals(other: Any?): Boolean {
        if (other is TraktPagedResponse<*>)
            return (super.equals(other) && other.page == page
                    && other.limit == limit
                    && other.pageCount == pageCount
                    && other.itemCount == itemCount)

        return false
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (page ?: 0)
        result = 31 * result + (pageCount ?: 0)
        result = 31 * result + (itemCount ?: 0)
        result = 31 * result + (limit ?: 0)
        return result
    }
}
