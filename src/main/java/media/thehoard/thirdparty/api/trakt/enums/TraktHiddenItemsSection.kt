package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktHiddenItemsSection constructor(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("calendar")
    CALENDAR(1, "calendar", "calendar", "Calendar"),
    @SerializedName("progress_watched")
    PROGRESS_WATCHED(2, "progress_watched", "progress_watched", "Progress Watched"),
    @SerializedName("progress_collected")
    PROGRESS_COLLECTED(4, "progress_collected", "progress_collected", "Progress Collected"),
    @SerializedName("recommendations")
    RECOMMENDATIONS(8, "recommendations", "recommendations", "Recommendations")
}
