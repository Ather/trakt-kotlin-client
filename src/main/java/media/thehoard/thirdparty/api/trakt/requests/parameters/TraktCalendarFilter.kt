package media.thehoard.thirdparty.api.trakt.requests.parameters

class TraktCalendarFilter(
        query: String? = null,
        startYear: Int? = null,
        endYear: Int? = null,
        genres: MutableSet<String>? = null,
        languages: MutableSet<String>? = null,
        countries: MutableSet<String>? = null,
        runtimes: IntRange? = null,
        ratings: IntRange? = null
) : TraktCommonFilter(startYear, endYear, genres, languages, countries, runtimes, ratings) {
    var query: String? = query
        set(query) {
            if (query != null)
                require(query.isNotEmpty())

            field = query
        }

    val hasQuerySet
        get() = !query.isNullOrBlank()

    override val hasValues
        get() = super.hasValues || hasQuerySet

    override fun clear() {
        super.clear()
        query = null
    }

    override fun getParameters(): MutableMap<String, String> {
        return super.getParameters().apply {
            if (hasQuerySet)
                this["query"] = query!!
        }
    }
}