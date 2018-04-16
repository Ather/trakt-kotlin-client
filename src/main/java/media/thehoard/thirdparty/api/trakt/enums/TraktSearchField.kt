package media.thehoard.thirdparty.api.trakt.enums


import com.google.gson.annotations.SerializedName

enum class TraktSearchField(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("title")
    TITLE(1, "title", "title", "Title"),
    @SerializedName("tagline")
    TAGLINE(2, "tagline", "tagline", "Tagline"),
    @SerializedName("overview")
    OVERVIEW(4, "overview", "overview", "Overview"),
    @SerializedName("people")
    PEOPLE(8, "people", "people", "People"),
    @SerializedName("translations")
    TRANSLATIONS(16, "translations", "translations", "Translations"),
    @SerializedName("aliases")
    ALIASES(32, "aliases", "aliases", "Aliases"),
    @SerializedName("name")
    NAME(64, "name", "name", "Name"),
    @SerializedName("biography")
    BIOGRAPHY(128, "biography", "biography", "Biography"),
    @SerializedName("description")
    DESCRIPTION(256, "description", "description", "Description");

    operator fun plus(searchField: TraktSearchField): CombinedTraktSearchField = CombinedTraktSearchField(this, searchField)

    operator fun plus(combinedSearchField: CombinedTraktSearchField): CombinedTraktSearchField = CombinedTraktSearchField(this, combinedSearchField)

    operator fun unaryPlus() = CombinedTraktSearchField(this)

    override fun toString() = displayName

    inner class CombinedTraktSearchField : TraktEnumeration {
        override var value: Int = 0

        override var objectName: String = ""

        override var uriName: String = ""

        override var displayName: String = ""

        constructor(original: TraktSearchField) {
            value = original.value
            objectName = original.objectName
            uriName = original.uriName
            displayName = original.displayName
        }

        constructor(original: TraktSearchField, secondary: TraktSearchField) {
            join(original, secondary)
        }

        constructor(original: TraktSearchField, secondary: CombinedTraktSearchField) {
            join(original, secondary)
        }

        constructor(original: CombinedTraktSearchField, secondary: TraktSearchField) {
            join(original, secondary)
        }

        constructor(original: CombinedTraktSearchField, secondary: CombinedTraktSearchField) {
            join(original, secondary)
        }

        private fun join(original: TraktEnumeration, secondary: TraktEnumeration) {
            value = original.value + secondary.value
            objectName = "${original.objectName},${secondary.objectName}"
            uriName = "${original.uriName},${secondary.uriName}"
            displayName = "${original.displayName}, ${secondary.displayName}"
        }

        operator fun plus(searchField: TraktSearchField): CombinedTraktSearchField = CombinedTraktSearchField(this, searchField)

        operator fun plus(combinedSearchField: CombinedTraktSearchField): CombinedTraktSearchField = CombinedTraktSearchField(this, combinedSearchField)

        override fun equals(other: Any?): Boolean {
            if (other is CombinedTraktSearchField)
                return this.objectName == other.objectName
            if (other is TraktSearchField)
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
