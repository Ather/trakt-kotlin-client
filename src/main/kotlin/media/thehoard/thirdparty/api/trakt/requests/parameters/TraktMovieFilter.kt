package media.thehoard.thirdparty.api.trakt.requests.parameters

class TraktMovieFilter(
        query: String? = null,
        startYear: Int? = null,
        endYear: Int? = null,
        genres: MutableSet<String>? = null,
        languages: MutableSet<String>? = null,
        countries: MutableSet<String>? = null,
        runtimes: IntRange? = null,
        ratings: IntRange? = null,
        certifications: MutableSet<String>?
) : TraktCommonMovieAndShowFilter(query, startYear, endYear, genres, languages, countries, runtimes, ratings, certifications)