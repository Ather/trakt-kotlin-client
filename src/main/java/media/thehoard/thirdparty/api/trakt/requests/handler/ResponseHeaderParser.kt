package media.thehoard.thirdparty.api.trakt.requests.handler

import io.netty.handler.codec.http.HttpHeaders
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortBy
import media.thehoard.thirdparty.api.trakt.enums.TraktListSortHow
import media.thehoard.thirdparty.api.trakt.responses.interfaces.ITraktPagedResponseHeaders
import media.thehoard.thirdparty.api.trakt.responses.interfaces.ITraktResponseHeaders
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

internal object ResponseHeaderParser {
    private const val HEADER_PAGINATION_PAGE_KEY = "X-Pagination-Page"
    private const val HEADER_PAGINATION_LIMIT_KEY = "X-Pagination-Limit"
    private const val HEADER_PAGINATION_PAGE_COUNT_KEY = "X-Pagination-Page-Count"
    private const val HEADER_PAGINATION_ITEM_COUNT_KEY = "X-Pagination-Item-Count"
    private const val HEADER_TRENDING_USER_COUNT_KEY = "X-Trending-User-Count"
    private const val HEADER_SORT_BY_KEY = "X-Sort-By"
    private const val HEADER_SORT_HOW_KEY = "X-Sort-How"
    private const val HEADER_STARTDATE_KEY = "X-Start-Date"
    private const val HEADER_ENDDATE_KEY = "X-End-Date"
    private const val HEADER_PRIVATE_USER_KEY = "X-Private-User"
    private const val HEADER_X_ITEM_ID = "X-Item-ID"
    private const val HEADER_X_ITEM_TYPE = "X-Item-Type"

    fun parseResponseHeaderValues(headerResults: ITraktResponseHeaders, responseHeaders: HttpHeaders) {
        when {
            HEADER_PAGINATION_PAGE_KEY in responseHeaders -> headerResults.page = responseHeaders[HEADER_PAGINATION_PAGE_KEY].toIntOrNull()
            HEADER_PAGINATION_LIMIT_KEY in responseHeaders -> headerResults.limit = responseHeaders[HEADER_PAGINATION_LIMIT_KEY].toIntOrNull()
            HEADER_TRENDING_USER_COUNT_KEY in responseHeaders -> headerResults.trendingUserCount = responseHeaders[HEADER_TRENDING_USER_COUNT_KEY].toIntOrNull()
            HEADER_SORT_BY_KEY in responseHeaders -> headerResults.sortBy = TraktListSortBy.valueOf(responseHeaders[HEADER_SORT_BY_KEY])
            HEADER_SORT_HOW_KEY in responseHeaders -> headerResults.sortHow = TraktListSortHow.valueOf(responseHeaders[HEADER_SORT_HOW_KEY])
            HEADER_PRIVATE_USER_KEY in responseHeaders -> headerResults.isPrivateUser = responseHeaders[HEADER_PRIVATE_USER_KEY]?.toBoolean()
            HEADER_STARTDATE_KEY in responseHeaders -> {
                headerResults.startDate = try {
                    ZonedDateTime.from(DateTimeFormatter.RFC_1123_DATE_TIME.parse(responseHeaders[HEADER_STARTDATE_KEY]))
                } catch (e: DateTimeParseException) {
                    null
                }
            }
            HEADER_ENDDATE_KEY in responseHeaders -> {
                headerResults.endDate = try {
                    ZonedDateTime.from(DateTimeFormatter.RFC_1123_DATE_TIME.parse(responseHeaders[HEADER_ENDDATE_KEY]))
                } catch (e: DateTimeParseException) {
                    null
                }
            }
            HEADER_X_ITEM_ID in responseHeaders -> headerResults.xItemId = responseHeaders[HEADER_X_ITEM_ID].toIntOrNull()
            HEADER_X_ITEM_TYPE in responseHeaders -> headerResults.xItemType = responseHeaders[HEADER_X_ITEM_TYPE]

        }
    }

    fun parsePagedResponseHeaderValue(headerResults: ITraktPagedResponseHeaders, responseHeaders: HttpHeaders) {
        parseResponseHeaderValues(headerResults, responseHeaders)

        when {
            HEADER_PAGINATION_PAGE_COUNT_KEY in responseHeaders -> headerResults.pageCount = responseHeaders[HEADER_PAGINATION_PAGE_COUNT_KEY].toIntOrNull()
            HEADER_PAGINATION_ITEM_COUNT_KEY in responseHeaders -> headerResults.itemCount = responseHeaders[HEADER_PAGINATION_ITEM_COUNT_KEY].toIntOrNull()
        }
    }
}