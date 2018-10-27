package com.atherapp.thirdparty.api.trakt.requests.handler

import com.atherapp.thirdparty.api.trakt.enums.TraktListSortBy
import com.atherapp.thirdparty.api.trakt.enums.TraktListSortHow
import com.atherapp.thirdparty.api.trakt.responses.interfaces.ITraktPagedResponseHeaders
import com.atherapp.thirdparty.api.trakt.responses.interfaces.ITraktResponseHeaders
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

    fun parseResponseHeaderValues(headerResults: ITraktResponseHeaders, responseHeaders: Map<String, List<String>>) {
        when {
            HEADER_PAGINATION_PAGE_KEY in responseHeaders.keys -> headerResults.page = responseHeaders[HEADER_PAGINATION_PAGE_KEY]?.firstOrNull()?.toIntOrNull()
            HEADER_PAGINATION_LIMIT_KEY in responseHeaders.keys -> headerResults.limit = responseHeaders[HEADER_PAGINATION_LIMIT_KEY]?.firstOrNull()?.toIntOrNull()
            HEADER_TRENDING_USER_COUNT_KEY in responseHeaders.keys -> headerResults.trendingUserCount = responseHeaders[HEADER_TRENDING_USER_COUNT_KEY]?.firstOrNull()?.toIntOrNull()
            HEADER_SORT_BY_KEY in responseHeaders.keys -> headerResults.sortBy = TraktListSortBy.valueOf(responseHeaders[HEADER_SORT_BY_KEY]?.first()!!)
            HEADER_SORT_HOW_KEY in responseHeaders.keys -> headerResults.sortHow = TraktListSortHow.valueOf(responseHeaders[HEADER_SORT_HOW_KEY]?.first()!!)
            HEADER_PRIVATE_USER_KEY in responseHeaders.keys -> headerResults.isPrivateUser = responseHeaders[HEADER_PRIVATE_USER_KEY]?.firstOrNull()?.toBoolean()
            HEADER_STARTDATE_KEY in responseHeaders.keys -> {
                headerResults.startDate = try {
                    ZonedDateTime.from(DateTimeFormatter.RFC_1123_DATE_TIME.parse(responseHeaders[HEADER_STARTDATE_KEY]?.firstOrNull()))
                } catch (e: DateTimeParseException) {
                    null
                }
            }
            HEADER_ENDDATE_KEY in responseHeaders.keys -> {
                headerResults.endDate = try {
                    ZonedDateTime.from(DateTimeFormatter.RFC_1123_DATE_TIME.parse(responseHeaders[HEADER_ENDDATE_KEY]?.firstOrNull()))
                } catch (e: DateTimeParseException) {
                    null
                }
            }
            HEADER_X_ITEM_ID in responseHeaders.keys -> headerResults.xItemId = responseHeaders[HEADER_X_ITEM_ID]?.firstOrNull()?.toIntOrNull()
            HEADER_X_ITEM_TYPE in responseHeaders.keys -> headerResults.xItemType = responseHeaders[HEADER_X_ITEM_TYPE]?.first()!!

        }
    }

    fun parsePagedResponseHeaderValue(headerResults: ITraktPagedResponseHeaders, responseHeaders: Map<String, List<String>>) {
        parseResponseHeaderValues(headerResults, responseHeaders)

        when {
            HEADER_PAGINATION_PAGE_COUNT_KEY in responseHeaders.keys -> headerResults.pageCount = responseHeaders[HEADER_PAGINATION_PAGE_COUNT_KEY]?.firstOrNull()?.toIntOrNull()
            HEADER_PAGINATION_ITEM_COUNT_KEY in responseHeaders.keys -> headerResults.itemCount = responseHeaders[HEADER_PAGINATION_ITEM_COUNT_KEY]?.firstOrNull()?.toIntOrNull()
        }
    }
}