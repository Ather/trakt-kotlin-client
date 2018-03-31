package media.thehoard.thirdparty.api.trakt.requests.handler

import jdk.incubator.http.HttpHeaders
import media.thehoard.thirdparty.api.trakt.responses.interfaces.ITraktPagedResponseHeaders
import media.thehoard.thirdparty.api.trakt.responses.interfaces.ITraktResponseHeaders
import java.time.Instant
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
        var values = responseHeaders.allValues(HEADER_PAGINATION_PAGE_KEY)
        if (values.isNotEmpty())
            try {
                val value = values.first().toInt()
                headerResults.page = value
            } catch (e: NumberFormatException) {
            }
        values = responseHeaders.allValues(HEADER_PAGINATION_LIMIT_KEY)
        if (values.isNotEmpty())
            try {
                val value = values.first().toInt()
                headerResults.limit = value
            } catch (e: NumberFormatException) {
            }
        values = responseHeaders.allValues(HEADER_TRENDING_USER_COUNT_KEY)
        if (values.isNotEmpty())
            try {
                val value = values.first().toInt()
                headerResults.trendingUserCount = value
            } catch (e: NumberFormatException) {
            }
        values = responseHeaders.allValues(HEADER_SORT_BY_KEY)
        if (values.isNotEmpty())
            headerResults.sortBy = values.first()
        values = responseHeaders.allValues(HEADER_SORT_HOW_KEY)
        if (values.isNotEmpty())
            headerResults.sortHow = values.first()
        values = responseHeaders.allValues(HEADER_PRIVATE_USER_KEY)
        if (values.isNotEmpty())
            try {
                val value = values.first()!!.toBoolean()
                headerResults.isPrivateUser = value
            } catch (e: NumberFormatException) {
            }
        values = responseHeaders.allValues(HEADER_STARTDATE_KEY)
        if (values.isNotEmpty())
            try {
                val value = DateTimeFormatter.RFC_1123_DATE_TIME.parse(values.first())
                headerResults.startDate = Instant.from(value)
            } catch (e: DateTimeParseException) {
            }
        values = responseHeaders.allValues(HEADER_ENDDATE_KEY)
        if (values.isNotEmpty())
            try {
                val value = DateTimeFormatter.RFC_1123_DATE_TIME.parse(values.first())
                headerResults.endDate = Instant.from(value)
            } catch (e: DateTimeParseException) {
            }
        values = responseHeaders.allValues(HEADER_X_ITEM_ID)
        if (values.isNotEmpty())
            try {
                val value = values.first().toInt()
                headerResults.xItemId = value
            } catch (e: NumberFormatException) {
            }
        values = responseHeaders.allValues(HEADER_X_ITEM_TYPE)
        if (values.isNotEmpty())
            headerResults.xItemType = values.first()
    }

    fun parsePagedResponseHeaderValue(headerResults: ITraktPagedResponseHeaders, responseHeaders: HttpHeaders) {
        parseResponseHeaderValues(headerResults, responseHeaders)

        var values = responseHeaders.allValues(HEADER_PAGINATION_PAGE_COUNT_KEY)
        if (values.isNotEmpty())
            try {
                val value = values.first().toInt()
                headerResults.pageCount = value
            } catch (e: NumberFormatException) {
            }
        values = responseHeaders.allValues(HEADER_PAGINATION_ITEM_COUNT_KEY)
        if (values.isNotEmpty())
            try {
                val value = values.first().toInt()
                headerResults.itemCount = value
            } catch (e: NumberFormatException) {
            }
    }
}