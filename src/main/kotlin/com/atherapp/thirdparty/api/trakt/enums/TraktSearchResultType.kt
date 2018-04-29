package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktSearchResultType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("movie")
    MOVIE(1, "movie", "movie", "Movie"),
    @SerializedName("show")
    SHOW(2, "show", "show", "Show"),
    @SerializedName("episode")
    EPISODE(4, "episode", "episode", "Episode"),
    @SerializedName("person")
    PERSON(8, "person", "person", "Person"),
    @SerializedName("list")
    LIST(16, "list", "list", "List");

    operator fun plus(searchResultType: TraktSearchResultType): CombinedTraktSearchResultType = CombinedTraktSearchResultType(this, searchResultType)

    operator fun plus(combinedSearchResultType: CombinedTraktSearchResultType): CombinedTraktSearchResultType = CombinedTraktSearchResultType(this, combinedSearchResultType)

    operator fun unaryPlus() = CombinedTraktSearchResultType(this)

    override fun toString() = displayName

    inner class CombinedTraktSearchResultType : TraktEnumeration {
        override var value: Int = 0

        override var objectName: String = ""

        override var uriName: String = ""

        override var displayName: String = ""

        constructor(original: TraktSearchResultType) {
            value = original.value
            objectName = original.objectName
            uriName = original.uriName
            displayName = original.displayName
        }

        constructor(original: TraktSearchResultType, secondary: TraktSearchResultType) {
            join(original, secondary)
        }

        constructor(original: TraktSearchResultType, secondary: CombinedTraktSearchResultType) {
            join(original, secondary)
        }

        constructor(original: CombinedTraktSearchResultType, secondary: TraktSearchResultType) {
            join(original, secondary)
        }

        constructor(original: CombinedTraktSearchResultType, secondary: CombinedTraktSearchResultType) {
            join(original, secondary)
        }

        private fun join(original: TraktEnumeration, secondary: TraktEnumeration) {
            value = original.value + secondary.value
            objectName = "${original.objectName},${secondary.objectName}"
            uriName = "${original.uriName},${secondary.uriName}"
            displayName = "${original.displayName}, ${secondary.displayName}"
        }

        operator fun plus(searchResultType: TraktSearchResultType): CombinedTraktSearchResultType = CombinedTraktSearchResultType(this, searchResultType)

        operator fun plus(combinedSearchResultType: CombinedTraktSearchResultType): CombinedTraktSearchResultType = CombinedTraktSearchResultType(this, combinedSearchResultType)

        override fun equals(other: Any?): Boolean {
            if (other is CombinedTraktSearchResultType)
                return this.objectName == other.objectName
            if (other is TraktSearchResultType)
                return this.objectName == other.objectName
            return false
        }

        override fun hashCode(): Int {
            var result = value
            result = 31 * result + objectName.hashCode()
            result = 31 * result + uriName.hashCode()
            result = 31 * result + displayName.hashCode()
            return result
        }

        override fun toString() = displayName
    }
}
