package media.thehoard.thirdparty.api.trakt.requests.search

import media.thehoard.thirdparty.api.trakt.enums.TraktSearchField
import media.thehoard.thirdparty.api.trakt.enums.TraktSearchIdType
import media.thehoard.thirdparty.api.trakt.enums.TraktSearchResultType
import media.thehoard.thirdparty.api.trakt.extensions.isValidStringId
import media.thehoard.thirdparty.api.trakt.extensions.validate
import media.thehoard.thirdparty.api.trakt.extensions.validateSpecified
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSearchResult
import media.thehoard.thirdparty.api.trakt.requests.base.AGetRequestHasResponse
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsFilter
import media.thehoard.thirdparty.api.trakt.requests.interfaces.ISupportsPagination
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktCommonFilter
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import java.util.*

internal sealed class ASearchRequest(
        override val uriTemplate: String,
        override var extendedInfo: TraktExtendedInfo? = null,
        internal open var resultTypes: TraktSearchResultType? = null,
        override var page: Int? = null,
        override var limit: Int? = null
) : AGetRequestHasResponse<TraktSearchResult>(TraktSearchResult::class), ISupportsExtendedInfo, ISupportsPagination {
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
        override val uriTemplate: String,
        override var extendedInfo: TraktExtendedInfo? = null,
        override var resultTypes: TraktSearchResultType? = null,
        override var page: Int? = null,
        override var limit: Int? = null,
        internal var idType: TraktSearchIdType,
        internal var lookupId: String
) : ASearchRequest(
        "search/{id_type}/{id}{?type,extended,page,limit}",
        extendedInfo,
        resultTypes,
        page,
        limit
) {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["id_type"] = idType.uriName
            this["id"] = lookupId

            if (resultTypes != null && resultTypes != TraktSearchResultType.UNSPECIFIED)
                this["type"] = resultTypes!!.uriName
        }

    override fun validate(variableName: String) {
        idType.validateSpecified("id type")
        lookupId.validate("lookup id", ::isValidStringId)
    }
}

internal class SearchTextQueryRequest(
        override var extendedInfo: TraktExtendedInfo? = null,
        override var resultTypes: TraktSearchResultType? = null,
        override var page: Int? = null,
        override var limit: Int? = null,
        override var filter: TraktCommonFilter? = null,
        internal var searchFields: TraktSearchField? = null,
        internal var query: String
) : ASearchRequest(
        "search/{type}{?query,fields,years,genres,languages,countries,runtimes,ratings,extended,page,limit}",
        extendedInfo,
        resultTypes,
        page,
        limit
), ISupportsFilter {
    override val uriPathParameters: Map<String, Any>?
        get() = (super.uriPathParameters as HashMap<String, Any>).apply {
            this["type"] = resultTypes!!.uriName
            this["query"] = query

            if (searchFields != null && searchFields != TraktSearchField.UNSPECIFIED)
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