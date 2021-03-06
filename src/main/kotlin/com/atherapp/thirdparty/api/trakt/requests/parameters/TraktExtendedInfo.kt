package com.atherapp.thirdparty.api.trakt.requests.parameters

import java.util.*

data class TraktExtendedInfo(
        var metadata: Boolean = false,
        var full: Boolean = false,
        var noSeasons: Boolean = false,
        var episodes: Boolean = false,
        var vip: Boolean = false
) {
    val hasAnySet
        get() = metadata || full || noSeasons || episodes || vip

    fun reset() {
        metadata = false
        full = false
        noSeasons = false
        episodes = false
        vip = false
    }

    fun resolve(): List<String> {
        return ArrayList<String>().apply {
            if (metadata) add("metadata")
            if (full) add("full")
            if (noSeasons) add("noseasons")
            if (episodes) add("episodes")
            if (vip) add ("vip")
        }
    }

    override fun toString(): String {
        return resolve().joinToString(",")
    }

    companion object {
        val METADATA = TraktExtendedInfo(metadata = true)
        val FULL = TraktExtendedInfo(full = true)
        val NO_SEASONS = TraktExtendedInfo(noSeasons = true)
        val EPISODES = TraktExtendedInfo(episodes = true)
        val VIP = TraktExtendedInfo(vip = true)
    }
}