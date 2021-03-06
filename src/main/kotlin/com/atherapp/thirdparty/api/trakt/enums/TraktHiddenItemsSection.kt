package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktHiddenItemsSection(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("calendar")
    CALENDAR(1, "calendar", "calendar", "Calendar"),
    @SerializedName("progress_watched")
    PROGRESS_WATCHED(2, "progress_watched", "progress_watched", "Progress Watched"),
    @SerializedName("progress_collected")
    PROGRESS_COLLECTED(4, "progress_collected", "progress_collected", "Progress Collected"),
    @SerializedName("recommendations")
    RECOMMENDATIONS(8, "recommendations", "recommendations", "Recommendations");

    override fun toString() = displayName
}
