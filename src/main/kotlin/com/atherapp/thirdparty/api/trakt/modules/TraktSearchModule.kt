package com.atherapp.thirdparty.api.trakt.modules

import com.atherapp.thirdparty.api.trakt.TraktClient
import com.atherapp.thirdparty.api.trakt.authentication.TraktAuthorization
import com.atherapp.thirdparty.api.trakt.enums.TraktSearchField
import com.atherapp.thirdparty.api.trakt.enums.TraktSearchIdType
import com.atherapp.thirdparty.api.trakt.enums.TraktSearchResultType
import com.atherapp.thirdparty.api.trakt.objects.basic.TraktSearchResult
import com.atherapp.thirdparty.api.trakt.requests.handler.RequestHandler
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import com.atherapp.thirdparty.api.trakt.requests.parameters.TraktSearchFilter
import com.atherapp.thirdparty.api.trakt.requests.search.SearchIdLookupRequest
import com.atherapp.thirdparty.api.trakt.requests.search.SearchTextQueryRequest
import com.atherapp.thirdparty.api.trakt.responses.TraktPagedResponse
import kotlinx.coroutines.Deferred

class TraktSearchModule internal constructor(override val client: TraktClient) : TraktModule {

    fun getTextQueryResultAsync(searchResultTypes: TraktSearchResultType, searchQuery: String, searchFields: TraktSearchField? = null, filter: TraktSearchFilter? = null, extendedInfo: TraktExtendedInfo? = null, pagedParameters: TraktPagedParameters? = null, requestAuthorization: TraktAuthorization = client.authorization
    ) = getTextQueryResultAsync(+searchResultTypes, searchQuery, if (searchFields != null) +searchFields else null, filter, extendedInfo, pagedParameters, requestAuthorization)

    fun getTextQueryResultAsync(searchResultTypes: TraktSearchResultType.CombinedTraktSearchResultType, searchQuery: String, searchFields: TraktSearchField? = null, filter: TraktSearchFilter? = null, extendedInfo: TraktExtendedInfo? = null, pagedParameters: TraktPagedParameters? = null, requestAuthorization: TraktAuthorization = client.authorization
    ) = getTextQueryResultAsync(searchResultTypes, searchQuery, if (searchFields != null) +searchFields else null, filter, extendedInfo, pagedParameters, requestAuthorization)

    fun getTextQueryResultAsync(searchResultTypes: TraktSearchResultType, searchQuery: String, searchFields: TraktSearchField.CombinedTraktSearchField? = null, filter: TraktSearchFilter? = null, extendedInfo: TraktExtendedInfo? = null, pagedParameters: TraktPagedParameters? = null, requestAuthorization: TraktAuthorization = client.authorization
    ) = getTextQueryResultAsync(+searchResultTypes, searchQuery, searchFields, filter, extendedInfo, pagedParameters, requestAuthorization)

    fun getTextQueryResultAsync(
            searchResultTypes: TraktSearchResultType.CombinedTraktSearchResultType,
            searchQuery: String,
            searchFields: TraktSearchField.CombinedTraktSearchField? = null,
            filter: TraktSearchFilter? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktPagedResponse<TraktSearchResult>> {
        return RequestHandler(client).executePagedRequestAsync(SearchTextQueryRequest(
                extendedInfo, searchResultTypes, pagedParameters?.page, pagedParameters?.limit, filter, searchFields, searchQuery
        ), requestAuthorization)
    }

    fun getIdLookupResultsAsync(searchIdType: TraktSearchIdType, lookupId: String, searchResultTypes: TraktSearchResultType, extendedInfo: TraktExtendedInfo? = null, pagedParameters: TraktPagedParameters? = null, requestAuthorization: TraktAuthorization = client.authorization
    ) = getIdLookupResultsAsync(searchIdType, lookupId, +searchResultTypes, extendedInfo, pagedParameters, requestAuthorization)

    fun getIdLookupResultsAsync(
            searchIdType: TraktSearchIdType,
            lookupId: String,
            searchResultTypes: TraktSearchResultType.CombinedTraktSearchResultType,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): Deferred<TraktPagedResponse<TraktSearchResult>> {
        return RequestHandler(client).executePagedRequestAsync(SearchIdLookupRequest(
                extendedInfo, searchResultTypes, pagedParameters?.page, pagedParameters?.limit, searchIdType, lookupId
        ), requestAuthorization)
    }
}
