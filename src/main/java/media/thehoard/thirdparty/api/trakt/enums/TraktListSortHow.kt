package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktListSortHow(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("asc")
    ASCENDING(1, "asc", "asc", "Ascending"),
    @SerializedName("desc")
    DESCENDING(1, "desc", "desc", "Descending"),
}