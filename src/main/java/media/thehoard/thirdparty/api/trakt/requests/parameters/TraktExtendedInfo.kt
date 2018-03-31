package media.thehoard.thirdparty.api.trakt.requests.parameters

import java.util.*

class TraktExtendedInfo(
        var metadata: Boolean = false,
        var full: Boolean = false,
        var noSeasons: Boolean = false,
        var episodes: Boolean = false
) {
    val hasAnySet
        get() = metadata || full || noSeasons || episodes

    fun reset() {
        metadata = false
        full = false
        noSeasons = false
        episodes = false
    }

    fun resolve(): List<String> {
        return ArrayList<String>().apply {
            if (metadata) add("metadata")
            if (full) add("full")
            if (noSeasons) add("noseasons")
            if (episodes) add("episodes")
        }
    }

    override fun toString(): String {
        return resolve().joinToString(",")
    }
}