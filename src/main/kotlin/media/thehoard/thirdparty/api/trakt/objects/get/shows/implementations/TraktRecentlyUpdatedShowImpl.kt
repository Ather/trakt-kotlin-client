package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktRecentlyUpdatedShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow
import java.time.ZonedDateTime

data class TraktRecentlyUpdatedShowImpl(
        @SerializedName("updated_at")
        override var recentlyUpdatedAt: ZonedDateTime? = null,
        override var show: TraktShow = TraktShowImpl()
) : TraktRecentlyUpdatedShow, TraktShow by show
