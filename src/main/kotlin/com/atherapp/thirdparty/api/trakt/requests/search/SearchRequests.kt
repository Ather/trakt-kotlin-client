package com.atherapp.thirdparty.api.trakt.requests.search

import com.atherapp.thirdparty.api.trakt.enums.TraktSearchField
import com.atherapp.thirdparty.api.trakt.enums.TraktSearchIdType
import com.atherapp.thirdparty.api.trakt.enums.TraktSearchResultType
import com.atherapp.thirdparty.api.trakt.extensions.isValidStringId
import com.atherapp.thirdparty.api.trakt.extensions.validate
import com.atherapp.thirdparty.api.trakt.extensions.validateSpecified
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSearchResult
import com.atherapp.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import com.atherapp.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import com.atherapp.thirdparty.api.trakt.requests.interfaces.ISupportsFilter
import com.atherapp.thirdparty.api.trakt.requests.interfaces.ISupportsPagination
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktCommonFilter
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.util.*

internal sealed class ASearchRequest(
        override val uriTemplate: String
) : AGetRequestHasResponse<TraktSearchResult>(TraktSearchResult::class), ISupportsExtendedInfo, ISupportsPagination {
    internal abstract var resultTypes: TraktSearchResultType.CombinedTraktSearchResultType?

    override val uriPathParameters: Map<String, Any>?
        get() = hashMapOf<String, String>().apply {
            if (extendedInfo != null && extendedInfo!!.hasAnySet)
                this["extended"] = extendedInfo!!.toString()
            if (page != null)
                this["page"] = page!!.toString()
            if (limit != null)
                this["limit"] = limit!!.toString()
        }
}

internal class SearchIdLookupRequest(
        override var extendedInfo: TraktExtendedInfo?,
        override var resultTypes: TraktSearchResultType.CombinedTraktSearchResultType?,
        override var page: Int?,
        override var limit: Int?,
        internal var idType: TraktSearchIdType,
        internal var lookupId: String
) : ASearchRequest(
        "search/{id_type}/{id}{?type,extended,page,limit}"
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["id_type"] = idType.uriName
            this["id"] = lookupId

            if (resultTypes != null && resultTypes!!.objectName != TraktSearchResultType.UNSPECIFIED.objectName)
                this["type"] = resultTypes!!.uriName
        }

    override fun validate(variableName: String) {
        idType.validateSpecified("id type")
        lookupId.validate("lookup id", ::isValidStringId)
    }
}

internal class SearchTextQueryRequest(
        override var extendedInfo: TraktExtendedInfo?,
        override var resultTypes: TraktSearchResultType.CombinedTraktSearchResultType?,
        override var page: Int?,
        override var limit: Int?,
        override var filter: TraktCommonFilter?,
        internal var searchFields: TraktSearchField.CombinedTraktSearchField?,
        internal var query: String
) : ASearchRequest(
        "search/{type}{?query,fields,years,genres,languages,countries,runtimes,ratings,extended,page,limit}"
), ISupportsFilter {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            if (resultTypes != null)
                this["type"] = resultTypes!!.uriName

            this["query"] = query

            if (searchFields != null && searchFields!!.objectName != TraktSearchField.UNSPECIFIED.objectName)
                this["fields"] = searchFields!!.uriName
            if (filter != null && filter!!.hasValues)
                for (parameter in filter!!.getParameters())
                    this[parameter.key] = parameter.value
        }

    override fun validate(variableName: String) {
        resultTypes.validateSpecified("id type")
        query.validate("query must not be empty", String::isNotBlank)
    }
}