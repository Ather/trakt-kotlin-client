package media.thehoard.thirdparty.api.trakt.requests.parameters

class TraktSearchFilter(
        startYear: Int? = null,
        endYear: Int? = null,
        genres: MutableSet<String>? = null,
        languages: MutableSet<String>? = null,
        countries: MutableSet<String>? = null,
        runtimes: IntRange? = null,
        ratings: IntRange? = null
) : TraktCommonFilter(startYear, endYear, genres, languages, countries, runtimes, ratings)