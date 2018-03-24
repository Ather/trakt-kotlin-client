package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktTimePeriod constructor(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("weekly")
    WEEKLY(1, "weekly", "weekly", "Weekly"),
    @SerializedName("monthly")
    MONTHLY(2, "monthly", "monthly", "Monthly"),
    @SerializedName("yearly")
    YEARLY(4, "yearly", "yearly", "Yearly"),
    @SerializedName("all")
    ALL(8, "all", "all", "All")
}
