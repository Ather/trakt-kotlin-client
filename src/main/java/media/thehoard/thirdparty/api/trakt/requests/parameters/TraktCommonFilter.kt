package media.thehoard.thirdparty.api.trakt.requests.parameters

import java.util.*

abstract class TraktCommonFilter protected constructor(
        startYear: Int? = null,
        endYear: Int? = null,
        var genres: MutableSet<String>? = null,
        var languages: MutableSet<String>? = null,
        var countries: MutableSet<String>? = null,
        runtimes: IntRange? = null,
        ratings: IntRange? = null
) {
    var startYear: Int? = startYear
        set(startYear) {
            if (startYear != null)
                require(startYear.isValidYear())
            field = startYear
        }

    var endYear: Int? = endYear
        set(endYear) {
            if (endYear != null)
                require(endYear.isValidYear())
            field = endYear
        }

    val hasStartYearSet
        get() = startYear != null && startYear!!.isValidYear()

    val hasEndYearSet
        get() = endYear != null && endYear!!.isValidYear()

    val hasYearsSet
        get() = hasStartYearSet || hasEndYearSet

    val hasGenresSet
        get() = genres != null && genres!!.isNotEmpty()

    val hasLanguagesSet
        get() = languages != null && languages!!.isNotEmpty()

    val hasCountriesSet
        get() = countries != null && countries!!.isNotEmpty()

    var runtimes: IntRange? = runtimes
        set(range) {
            if (range != null)
                require(range.first >= 0 && range.last >= 0 && range.first <= range.last)

            field = range
        }

    val hasRuntimesSet
        get() = runtimes != null && runtimes!!.first > 0 && runtimes!!.last > 0 && runtimes!!.last > runtimes!!.first

    var ratings: IntRange? = ratings
        set(range) {
            if (range != null)
                require(range.first >= 0 && range.last >= 0 && range.first <= range.last && range.last <= 100)

            field = range
        }

    val hasRatingsSet
        get() = runtimes != null && runtimes!!.first > 0 && runtimes!!.last > 0 && runtimes!!.last > runtimes!!.first && runtimes!!.last <= 100

    open val hasValues
        get() = hasYearsSet || hasGenresSet || hasLanguagesSet || hasCountriesSet || hasRuntimesSet || hasRatingsSet

    fun addGenres(vararg genres: String) = addGenres(true, *genres)

    fun setGenres(vararg genres: String) = addGenres(false, *genres)

    fun addLanguages(vararg languages: String) = addLanguages(true, *languages)

    fun setLanguages(vararg languages: String) = addLanguages(false, *languages)

    fun addCountries(vararg countries: String) = addCountries(true, *countries)

    fun setCountries(vararg countries: String) = addCountries(false, *countries)

    open fun clear() {
        startYear = null
        endYear = null
        genres = null
        languages = null
        countries = null
        runtimes = null
        ratings = null
    }

    open fun getParameters(): MutableMap<String, String> {
        val parameters = hashMapOf<String, String>()

        if (hasStartYearSet && !hasEndYearSet) parameters["years"] = startYear.toString()
        else if (!hasStartYearSet && hasEndYearSet) parameters["years"] = endYear.toString()
        else if (hasStartYearSet && hasEndYearSet) {
            if (startYear!! <= endYear!!)
                parameters["years"] = "$startYear-$endYear"
            else
                parameters["years"] = "$endYear-$startYear"
        }

        if (hasGenresSet)
            parameters["genres"] = genres!!.joinToString(",")
        if (hasLanguagesSet)
            parameters["languages"] = languages!!.joinToString(",")
        if (hasCountriesSet)
            parameters["countries"] = languages!!.joinToString(",")

        if (hasRuntimesSet)
            parameters["runtimes"] = "${runtimes!!.first}-${runtimes!!.last}"

        if (hasRatingsSet)
            parameters["ratings"] = "${ratings!!.first}-${ratings!!.last}"

        return parameters
    }

    private fun addGenres(keepExisting: Boolean, vararg genres: String) {
        if (this.genres == null && keepExisting)
            this.genres = HashSet(if (keepExisting) this.genres!!.size + genres.size else genres.size)

        if (keepExisting && this.genres != null)
            this.genres!!.addAll(genres.filter { s -> s.isNotBlank() })
        else if (!keepExisting) {
            this.genres!!.clear()
            this.genres!!.addAll(genres.filter { s -> s.isNotBlank() })
        }
    }

    private fun addLanguages(keepExisting: Boolean, vararg languages: String) {
        if (this.languages == null && keepExisting)
            this.languages = HashSet(if (keepExisting) this.languages!!.size + languages.size else languages.size)

        if (keepExisting && this.languages != null)
            this.languages!!.addAll(languages.filter { s -> s.isValidLanguageOrCountry() })
        else if (!keepExisting) {
            this.languages!!.clear()
            this.languages!!.addAll(languages.filter { s -> s.isValidLanguageOrCountry() })
        }
    }

    private fun addCountries(keepExisting: Boolean, vararg countries: String) {
        if (this.countries == null && keepExisting)
            this.countries = HashSet(if (keepExisting) this.countries!!.size + countries.size else countries.size)

        if (keepExisting && this.countries != null)
            this.countries!!.addAll(countries.filter { s -> s.isValidLanguageOrCountry() })
        else if (!keepExisting) {
            this.countries!!.clear()
            this.countries!!.addAll(countries.filter { s -> s.isValidLanguageOrCountry() })
        }
    }

    private fun Int.isValidYear(): Boolean = this >= 0 && this.toString().length == 4

    private fun String.isValidLanguageOrCountry(): Boolean = this.length == 2

    override fun toString(): String {
        val parameters = getParameters()

        if (parameters.isEmpty())
            return ""

        return parameters.map { param -> "${param.key}=${param.value}" }.joinToString("&")
    }
}