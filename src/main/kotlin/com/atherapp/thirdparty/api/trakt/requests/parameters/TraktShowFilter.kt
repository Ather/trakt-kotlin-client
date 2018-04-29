package com.atherapp.thirdparty.api.trakt.requests.parameters

import com.atherapp.thirdparty.api.trakt.enums.TraktShowStatus
import java.util.*

class TraktShowFilter(
        query: String? = null,
        startYear: Int? = null,
        endYear: Int? = null,
        genres: MutableSet<String>? = null,
        languages: MutableSet<String>? = null,
        countries: MutableSet<String>? = null,
        runtimes: IntRange? = null,
        ratings: IntRange? = null,
        certifications: MutableSet<String>? = null,
        var networks: MutableSet<String>? = null,
        var states: MutableSet<TraktShowStatus>? = null
) : TraktCommonMovieAndShowFilter(query, startYear, endYear, genres, languages, countries, runtimes, ratings, certifications) {
    val hasNetworksSet
        get() = networks != null && networks!!.size > 0

    val hasStatesSet
        get() = states != null && states!!.size > 0

    override val hasValues: Boolean
        get() = super.hasValues || hasNetworksSet || hasStatesSet

    fun addNetworks(vararg networks: String) = addNetworks(true, *networks)

    fun setNetworks(vararg networks: String) = addNetworks(false, *networks)

    fun addStates(vararg states: TraktShowStatus) = addStates(true, *states)

    fun setStates(vararg states: TraktShowStatus) = addStates(false, *states)

    override fun clear() {
        super.clear()
        networks = null
        states = null
    }

    override fun getParameters(): MutableMap<String, String> {
        return super.getParameters().apply {
            if (hasNetworksSet)
                this["networks"] = networks!!.joinToString(",")
            if (hasStatesSet)
                this["status"] = states!!.joinToString(",", transform = TraktShowStatus::uriName)
        }
    }

    private fun addNetworks(keepExisting: Boolean, vararg networks: String) {
        if (this.networks == null && keepExisting)
            this.networks = HashSet(if (keepExisting) this.networks!!.size + networks.size else networks.size)

        if (keepExisting && this.networks != null)
            this.networks!!.addAll(networks)
        else if (!keepExisting) {
            this.networks!!.clear()
            this.networks!!.addAll(networks)
        }
    }

    private fun addStates(keepExisting: Boolean, vararg states: TraktShowStatus) {
        if (this.states == null && keepExisting)
            this.states = HashSet(if (keepExisting) this.states!!.size + states.size else states.size)

        if (keepExisting && this.states != null)
            this.states!!.addAll(states.filter { state -> state != TraktShowStatus.UNSPECIFIED })
        else if (!keepExisting) {
            this.states!!.clear()
            this.states!!.addAll(states.filter { state -> state != TraktShowStatus.UNSPECIFIED })
        }
    }
}