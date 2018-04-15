package media.thehoard.thirdparty.api.trakt.modules

import media.thehoard.thirdparty.api.trakt.TraktClient
import media.thehoard.thirdparty.api.trakt.authentication.TraktAuthorization
import media.thehoard.thirdparty.api.trakt.enums.TraktSearchField
import media.thehoard.thirdparty.api.trakt.enums.TraktSearchIdType
import media.thehoard.thirdparty.api.trakt.enums.TraktSearchResultType
import media.thehoard.thirdparty.api.trakt.objects.basic.TraktSearchResult
import media.thehoard.thirdparty.api.trakt.requests.handler.RequestHandler
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktExtendedInfo
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktPagedParameters
import media.thehoard.thirdparty.api.trakt.requests.parameters.TraktSearchFilter
import media.thehoard.thirdparty.api.trakt.requests.search.SearchIdLookupRequest
import media.thehoard.thirdparty.api.trakt.requests.search.SearchTextQueryRequest
import media.thehoard.thirdparty.api.trakt.responses.TraktPagedResponse
import java.util.concurrent.CompletableFuture

class TraktSearchModule internal constructor(override val client: TraktClient) : TraktModule {
    //TODO Support combined enums
    fun getTextQueryResultAsync(
            searchResultTypes: TraktSearchResultType,
            searchQuery: String,
            searchFields: TraktSearchField? = null,
            filter: TraktSearchFilter? = null,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktSearchResult>> {
        return RequestHandler(client).executePagedRequestAsync(SearchTextQueryRequest(
                extendedInfo, searchResultTypes, pagedParameters?.page, pagedParameters?.limit, filter, searchFields, searchQuery
        ), requestAuthorization)
    }

    fun getIdLookupResultsAsync(
            searchIdType: TraktSearchIdType,
            lookupId: String,
            searchResultTypes: TraktSearchResultType,
            extendedInfo: TraktExtendedInfo? = null,
            pagedParameters: TraktPagedParameters? = null,
            requestAuthorization: TraktAuthorization = client.authorization
    ): CompletableFuture<TraktPagedResponse<TraktSearchResult>> {
        return RequestHandler(client).executePagedRequestAsync(SearchIdLookupRequest(
                extendedInfo, searchResultTypes, pagedParameters?.page, pagedParameters?.limit, searchIdType, lookupId
        ), requestAuthorization)
    }
}
