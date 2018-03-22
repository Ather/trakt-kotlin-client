package media.thehoard.thirdparty.api.trakt.objects.get.movies.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.enums.TraktReleaseType
import media.thehoard.thirdparty.api.trakt.objects.get.movies.TraktMovieRelease
import java.util.*

data class TraktMovieReleaseImpl(override var country: String = "",
                                 override var certification: String = "",
                                 @SerializedName("release_date")
                                 override var releaseDate: Date? = null,
                                 @SerializedName("release_type")
                                 override var releaseType: TraktReleaseType = TraktReleaseType.UNSPECIFIED,
                                 override var note: String = "") : TraktMovieRelease
