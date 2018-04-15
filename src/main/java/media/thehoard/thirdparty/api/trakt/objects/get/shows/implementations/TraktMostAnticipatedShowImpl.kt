package media.thehoard.thirdparty.api.trakt.objects.get.shows.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktMostAnticipatedShow
import media.thehoard.thirdparty.api.trakt.objects.get.shows.TraktShow

data class TraktMostAnticipatedShowImpl(
        @SerializedName("list_count")
        override var listCount: Int? = null,
        override var show: TraktShow = TraktShowImpl()
) : TraktMostAnticipatedShow, TraktShow by show
