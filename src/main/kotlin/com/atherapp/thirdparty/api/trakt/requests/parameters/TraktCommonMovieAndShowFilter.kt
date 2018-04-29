package com.atherapp.thirdparty.api.trakt.requests.parameters

import java.util.*

abstract class TraktCommonMovieAndShowFilter(
        query: String? = null,
        startYear: Int? = null,
        endYear: Int? = null,
        genres: MutableSet<String>? = null,
        languages: MutableSet<String>? = null,
        countries: MutableSet<String>? = null,
        runtimes: IntRange? = null,
        ratings: IntRange? = null,
        var certifications: MutableSet<String>? = null
) : TraktCommonFilter(startYear, endYear, genres, languages, countries, runtimes, ratings) {
    var query: String? = query
        set(query) {
            if (query != null)
                require(query.isNotEmpty())

            field = query
        }

    val hasQuerySet
        get() = !query.isNullOrBlank()

    val hasCertificationsSet
        get() = certifications != null && certifications!!.size > 0

    override
    val hasValues
        get() = super.hasValues || hasQuerySet

    fun addCertifications(vararg certifications: String) = addCertifications(true, *certifications)

    fun setCertifications(vararg certifications: String) = addCertifications(false, *certifications)

    override fun clear() {
        super.clear()
        query = null
        certifications = null
    }

    override fun getParameters(): MutableMap<String, String> {
        val parameters = super.getParameters()

        if (hasQuerySet)
            parameters["query"] = query!!

        if (hasCertificationsSet)
            parameters["certifications"] = certifications!!.joinToString(",")

        return parameters
    }

    private fun addCertifications(keepExisting: Boolean, vararg certifications: String) {
        if (this.certifications == null && keepExisting)
            this.certifications = HashSet(if (keepExisting) this.certifications!!.size + certifications.size else certifications.size)

        if (keepExisting && this.certifications != null)
            this.certifications!!.addAll(certifications)
        else if (!keepExisting) {
            this.certifications!!.clear()
            this.certifications!!.addAll(certifications)
        }
    }
}